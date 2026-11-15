package itemsadder.m;

import itemsadder.m.uq;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ur {
    public static final List LQ = Arrays.asList("af_za", "ar_sa", "ast_es", "az_az", "bar", "be_by", "bg_bg", "brb", "br_fr", "bs_ba", "ca_es", "cs_cz", "cy_gb", "da_dk", "de_at", "de_ch", "de_de", "el_gr", "enp", "enws", "en_au", "en_ca", "en_gb", "en_nz", "en_pt", "en_us", "eo_uy", "es_ar", "es_cl", "es_es", "es_mx", "es_uy", "es_ve", "et_ee", "eu_es", "fa_ir", "fil_ph", "fi_fi", "fo_fo", "fra_de", "fr_ca", "fr_fr", "fy_nl", "ga_ie", "gd_gb", "gl_es", "gv_im", "haw_us", "he_il", "hi_in", "hr_hr", "hu_hu", "hy_am", "id_id", "ig_ng", "io_en", "is_is", "it_it", "ja_jp", "jbo_en", "kab_kab", "ka_ge", "kk_kz", "kn_in", "ko_kr", "ksh", "kw_gb", "la_la", "lb_lu", "li_li", "lol_us", "lt_lt", "lv_lv", "mi_nz", "mk_mk", "mn_mn", "moh_ca", "ms_my", "mt_mt", "nds_de", "nl_be", "nl_nl", "nn_no", "no_no", "nuk", "oc_fr", "oj_ca", "ovd", "pl_pl", "pt_br", "pt_pt", "qya_aa", "ro_ro", "ru_ru", "se_no", "sk_sk", "sl_si", "so_so", "sq_al", "sr_sp", "sv_se", "swg", "sxu", "szl", "ta_in", "th_th", "tlh_aa", "tr_tr", "tt_ru", "tzl_tzl", "uk_ua", "val_es", "vec_it", "vi_vn", "yo_ng", "zh_cn", "zh_tw");
    private HashMap LR = new HashMap();

    public void d(String string, String string3, String string4) {
        uq uq2 = this.LR.computeIfAbsent(string, string2 -> new uq(string));
        uq2.u(string3, string4);
    }

    public HashMap qM() {
        HashMap hashMap = new HashMap();
        this.LR.forEach((string, uq2) -> hashMap.put(string, uq2.qL()));
        return hashMap;
    }

    public void clear() {
        this.LR.clear();
        this.LR = new HashMap();
    }
}
