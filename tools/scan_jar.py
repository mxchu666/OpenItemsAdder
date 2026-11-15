import zipfile, re, collections, os, sys, json

if len(sys.argv) < 2:
    sys.exit("usage: python scan_jar.py <path-to.jar>")
jar = sys.argv[1]
z = zipfile.ZipFile(jar)
files = z.namelist()
print("entries", len(files))
exts = collections.Counter(os.path.splitext(f)[1].lower() for f in files)
print("extensions", exts.most_common(30))

print("\n== non-class, non-common-asset entries ==")
common = {'.class', '.png', '.json', '.yml', '.yaml', '.txt', '.properties', '.ogg',
          '.wav', '.bbmodel', '.mcmeta', '.zip', '.jar', '.md', '.html', '.css', '.js',
          '.ttf', '.otf', '.lang', '.csv', '.toml', '.xml'}
for f in files:
    ext = os.path.splitext(f)[1].lower()
    if ext not in common:
        print(f, z.getinfo(f).file_size)

urls, ips, b64, natives, all_strings = set(), set(), [], [], []
for f in files:
    if not f.endswith(('.class', '.yml', '.json', '.txt', '.properties', '.xml')):
        continue
    data = z.read(f)
    if f.endswith('.class'):
        for s in re.findall(rb'[\x20-\x7e]{6,}', data):
            t = s.decode('latin1')
            all_strings.append((f, t))
            for u in re.findall(r'https?://[^\s"\'<>)]+', t):
                urls.add((f, u))
            for ip in re.findall(r'\b(?:\d{1,3}\.){3}\d{1,3}\b', t):
                ips.add((f, ip))
            if re.fullmatch(r'[A-Za-z0-9+/=]{60,}', t) and len(t) % 4 == 0:
                b64.append((f, t[:100], len(t)))
            if re.search(r'\.(dll|so|dylib|exe|bat|ps1|vbs|js)$', t, re.I):
                natives.append((f, t[:160]))

print("\n== URLs ==", len(urls))
for f, u in sorted(urls):
    print(f, u)
print("\n== IPs ==", sorted(ips))
print("\n== long base64 candidates ==", len(b64))
for f, t, l in b64[:60]:
    print(f, l, t)
print("\n== native/binary refs ==", len(natives))
for f, t in natives[:100]:
    print(f, t)

keywords = ['discord', 'webhook', 'token', 'leveldb', 'Local Storage', 'Login Data',
            'wallet', 'chrome', 'firefox', 'brave', 'opera', 'user.home', 'AppData',
            'ProcessBuilder', 'Runtime.getRuntime', 'defineClass', 'Unsafe',
            'System.load', 'clipboard', 'keylog', 'ransom', 'stealer', 'grabber',
            'cookies', 'password', 'credential', 'ssh', 'telegram', 'bot']
print("\n== keyword hits ==")
counts = collections.Counter()
examples = collections.defaultdict(list)
for f, t in all_strings:
    low = t.lower()
    for k in keywords:
        if k.lower() in low:
            counts[k] += 1
            if len(examples[k]) < 8:
                examples[k].append((f, t[:200]))
for k, c in counts.most_common():
    print(f"\n-- {k}: {c}")
    for f, t in examples[k]:
        print("   ", f, "::", t)

print("\n== suspicious string constants (len>40, non-URL, high entropy) ==")
def entropy(s):
    if not s: return 0
    from math import log2
    p = [s.count(c)/len(s) for c in set(s)]
    return -sum(x*log2(x) for x in p)
seen = set()
for f, t in all_strings:
    if len(t) >= 40 and 'http' not in t.lower() and t not in seen:
        e = entropy(t)
        if e > 5.0:
            seen.add(t)
            print(f, round(e, 2), t[:160])
