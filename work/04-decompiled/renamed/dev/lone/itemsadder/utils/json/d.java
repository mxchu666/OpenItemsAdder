package dev.lone.itemsadder.utils.json;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.ParseContext;
import com.jayway.jsonpath.spi.json.JsonProvider;
import dev.lone.itemsadder.utils.json.Fastjson2JsonProvider;

final class d {
    private static final ParseContext aCR = JsonPath.using((Configuration)Configuration.builder().jsonProvider((JsonProvider)new Fastjson2JsonProvider()).options(new Option[]{Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS}).build());

    private d() {
    }
}
