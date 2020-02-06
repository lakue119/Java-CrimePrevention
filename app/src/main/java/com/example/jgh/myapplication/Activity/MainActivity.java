package com.example.jgh.myapplication.Activity;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.jgh.myapplication.Model.ArraylocalData;
import com.example.jgh.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //region 변수선언
    public static ArraylocalData seoul_all = new ArraylocalData();
    public static ArraylocalData seoul_dobong = new ArraylocalData();
    public static ArraylocalData seoul_dongdaemun = new ArraylocalData();
    public static ArraylocalData seoul_dongjak = new ArraylocalData();
    public static ArraylocalData seoul_eunpyeong = new ArraylocalData();
    public static ArraylocalData seoul_gangbuk = new ArraylocalData();
    public static ArraylocalData seoul_gangdong = new ArraylocalData();
    public static ArraylocalData seoul_gangnam = new ArraylocalData();
    public static ArraylocalData seoul_gangseo = new ArraylocalData();
    public static ArraylocalData seoul_geumcheon = new ArraylocalData();
    public static ArraylocalData seoul_guro = new ArraylocalData();
    public static ArraylocalData seoul_gwanak = new ArraylocalData();
    public static ArraylocalData seoul_gwangjin = new ArraylocalData();
    public static ArraylocalData seoul_jongno = new ArraylocalData();
    public static ArraylocalData seoul_junggu = new ArraylocalData();
    public static ArraylocalData seoul_jungnang = new ArraylocalData();
    public static ArraylocalData seoul_mapo = new ArraylocalData();
    public static ArraylocalData seoul_nowon = new ArraylocalData();
    public static ArraylocalData seoul_seocho = new ArraylocalData();
    public static ArraylocalData seoul_seodaemun = new ArraylocalData();
    public static ArraylocalData seoul_seongbuk = new ArraylocalData();
    public static ArraylocalData seoul_seongdong = new ArraylocalData();
    public static ArraylocalData seoul_songpa = new ArraylocalData();
    public static ArraylocalData seoul_yangchun = new ArraylocalData();
    public static ArraylocalData seoul_yeongdeungpo = new ArraylocalData();
    public static ArraylocalData seoul_yongsan = new ArraylocalData();
    public static ArraylocalData gyunggi_all = new ArraylocalData();
    public static ArraylocalData gyunggi_ansan = new ArraylocalData();
    public static ArraylocalData gyunggi_anseong = new ArraylocalData();
    public static ArraylocalData gyunggi_anyang = new ArraylocalData();
    public static ArraylocalData gyunggi_bucheon = new ArraylocalData();
    public static ArraylocalData gyunggi_dongducheon = new ArraylocalData();
    public static ArraylocalData gyunggi_gapyeong = new ArraylocalData();
    public static ArraylocalData gyunggi_gimpo = new ArraylocalData();
    public static ArraylocalData gyunggi_goyang = new ArraylocalData();
    public static ArraylocalData gyunggi_gunpo = new ArraylocalData();
    public static ArraylocalData gyunggi_guri = new ArraylocalData();
    public static ArraylocalData gyunggi_gwacheon = new ArraylocalData();
    public static ArraylocalData gyunggi_gwangmyeong = new ArraylocalData();
    public static ArraylocalData gyunggi_gwangju = new ArraylocalData();
    public static ArraylocalData gyunggi_hanam = new ArraylocalData();
    public static ArraylocalData gyunggi_hwaseong = new ArraylocalData();
    public static ArraylocalData gyunggi_icheon = new ArraylocalData();
    public static ArraylocalData gyunggi_namyangju = new ArraylocalData();
    public static ArraylocalData gyunggi_osan = new ArraylocalData();
    public static ArraylocalData gyunggi_paju = new ArraylocalData();
    public static ArraylocalData gyunggi_pocheon = new ArraylocalData();
    public static ArraylocalData gyunggi_pyeongtaek = new ArraylocalData();
    public static ArraylocalData gyunggi_seongnam = new ArraylocalData();
    public static ArraylocalData gyunggi_siheung = new ArraylocalData();
    public static ArraylocalData gyunggi_suwon = new ArraylocalData();
    public static ArraylocalData gyunggi_uijeongbu = new ArraylocalData();
    public static ArraylocalData gyunggi_uiwang = new ArraylocalData();
    public static ArraylocalData gyunggi_yangju = new ArraylocalData();
    public static ArraylocalData gyunggi_yangpyeong = new ArraylocalData();
    public static ArraylocalData gyunggi_yeoju = new ArraylocalData();
    public static ArraylocalData gyunggi_yeoncheon = new ArraylocalData();
    public static ArraylocalData gyunggi_yongin = new ArraylocalData();
    public static ArraylocalData inchun_all = new ArraylocalData();
    public static ArraylocalData inchun_bupyeong = new ArraylocalData();
    public static ArraylocalData inchun_donggu = new ArraylocalData();
    public static ArraylocalData inchun_ganghwa = new ArraylocalData();
    public static ArraylocalData inchun_gyeyang = new ArraylocalData();
    public static ArraylocalData inchun__junggu = new ArraylocalData();
    public static ArraylocalData inchun_namdonggu = new ArraylocalData();
    public static ArraylocalData inchun_namgu = new ArraylocalData();
    public static ArraylocalData inchun_ongjin = new ArraylocalData();
    public static ArraylocalData inchun_seogu = new ArraylocalData();
    public static ArraylocalData inchun_yeonsu = new ArraylocalData();
    public static ArraylocalData gangwon_all = new ArraylocalData();
    public static ArraylocalData gangwon_cheorwon = new ArraylocalData();
    public static ArraylocalData gangwon_chuncheon = new ArraylocalData();
    public static ArraylocalData gangwon_donghae = new ArraylocalData();
    public static ArraylocalData gangwon_gangneung = new ArraylocalData();
    public static ArraylocalData gangwon_goseong = new ArraylocalData();
    public static ArraylocalData gangwon_hoengseong = new ArraylocalData();
    public static ArraylocalData gangwon_hongcheon = new ArraylocalData();
    public static ArraylocalData gangwon_hwacheon = new ArraylocalData();
    public static ArraylocalData gangwon_inje = new ArraylocalData();
    public static ArraylocalData gangwon_jeongseon = new ArraylocalData();
    public static ArraylocalData gangwon_pyeongchang = new ArraylocalData();
    public static ArraylocalData gangwon_samcheok = new ArraylocalData();
    public static ArraylocalData gangwon_sokcho = new ArraylocalData();
    public static ArraylocalData gangwon_taebaek = new ArraylocalData();
    public static ArraylocalData gangwon_wonju = new ArraylocalData();
    public static ArraylocalData gangwon_yanggu = new ArraylocalData();
    public static ArraylocalData gangwon_yangyang = new ArraylocalData();
    public static ArraylocalData gangwon_yeongwol = new ArraylocalData();
    public static ArraylocalData gwangju_all = new ArraylocalData();
    public static ArraylocalData gwangju_bukgu = new ArraylocalData();
    public static ArraylocalData gwangju_donggu = new ArraylocalData();
    public static ArraylocalData gwangju_gwangsan = new ArraylocalData();
    public static ArraylocalData gwangju_namgu = new ArraylocalData();
    public static ArraylocalData gwangju_seogu = new ArraylocalData();
    public static ArraylocalData chungnam_all = new ArraylocalData();
    public static ArraylocalData chungnam_asan = new ArraylocalData();
    public static ArraylocalData chungnam_boryeong = new ArraylocalData();
    public static ArraylocalData chungnam_buyeo = new ArraylocalData();
    public static ArraylocalData chungnam_cheonan = new ArraylocalData();
    public static ArraylocalData chungnam_cheongyang = new ArraylocalData();
    public static ArraylocalData chungnam_dangjin = new ArraylocalData();
    public static ArraylocalData chungnam_geumsan = new ArraylocalData();
    public static ArraylocalData chungnam_gongju = new ArraylocalData();
    public static ArraylocalData chungnam_gyeryong = new ArraylocalData();
    public static ArraylocalData chungnam_hongseong = new ArraylocalData();
    public static ArraylocalData chungnam_nonsan = new ArraylocalData();
    public static ArraylocalData chungnam_sejong = new ArraylocalData();
    public static ArraylocalData chungnam_seocheon = new ArraylocalData();
    public static ArraylocalData chungnam_seosan = new ArraylocalData();
    public static ArraylocalData chungnam_taean = new ArraylocalData();
    public static ArraylocalData chungnam_yesan = new ArraylocalData();
    public static ArraylocalData chungbuk_all = new ArraylocalData();
    public static ArraylocalData chungbuk_boeun = new ArraylocalData();
    public static ArraylocalData chungbuk_cheongju = new ArraylocalData();
    public static ArraylocalData chungbuk_chungju = new ArraylocalData();
    public static ArraylocalData chungbuk_danyang = new ArraylocalData();
    public static ArraylocalData chungbuk_eumseong = new ArraylocalData();
    public static ArraylocalData chungbuk_goesan = new ArraylocalData();
    public static ArraylocalData chungbuk_jecheon = new ArraylocalData();
    public static ArraylocalData chungbuk_jeungpyeong = new ArraylocalData();
    public static ArraylocalData chungbuk_jincheon = new ArraylocalData();
    public static ArraylocalData chungbuk_okcheon = new ArraylocalData();
    public static ArraylocalData chungbuk_yeongdong = new ArraylocalData();
    public static ArraylocalData daejeon_all = new ArraylocalData();
    public static ArraylocalData daejeon_daedeok = new ArraylocalData();
    public static ArraylocalData daejeon_donggu = new ArraylocalData();
    public static ArraylocalData daejeon_junggu = new ArraylocalData();
    public static ArraylocalData daejeon_seogu = new ArraylocalData();
    public static ArraylocalData daejeon_yuseong = new ArraylocalData();
    public static ArraylocalData gyungbuk_all = new ArraylocalData();
    public static ArraylocalData gyungbuk_andong = new ArraylocalData();
    public static ArraylocalData gyungbuk_bonghwa = new ArraylocalData();
    public static ArraylocalData gyungbuk_cheongdo = new ArraylocalData();
    public static ArraylocalData gyungbuk_cheongsong = new ArraylocalData();
    public static ArraylocalData gyungbuk_chilgok = new ArraylocalData();
    public static ArraylocalData gyungbuk_gimcheon = new ArraylocalData();
    public static ArraylocalData gyungbuk_goryeong = new ArraylocalData();
    public static ArraylocalData gyungbuk_gumi = new ArraylocalData();
    public static ArraylocalData gyungbuk_gunwi = new ArraylocalData();
    public static ArraylocalData gyungbuk_gyeongju = new ArraylocalData();
    public static ArraylocalData gyungbuk_gyeongsan = new ArraylocalData();
    public static ArraylocalData gyungbuk_mungyeong = new ArraylocalData();
    public static ArraylocalData gyungbuk_pohang = new ArraylocalData();
    public static ArraylocalData gyungbuk_sangju = new ArraylocalData();
    public static ArraylocalData gyungbuk_seongju = new ArraylocalData();
    public static ArraylocalData gyungbuk_uiseong = new ArraylocalData();
    public static ArraylocalData gyungbuk_uljin = new ArraylocalData();
    public static ArraylocalData gyungbuk_yecheon = new ArraylocalData();
    public static ArraylocalData gyungbuk_yeongcheon = new ArraylocalData();
    public static ArraylocalData gyungbuk_yeongdeok = new ArraylocalData();
    public static ArraylocalData gyungbuk_yeongju = new ArraylocalData();
    public static ArraylocalData gyungbuk_yeongyang = new ArraylocalData();
    public static ArraylocalData daegu_all = new ArraylocalData();
    public static ArraylocalData daegu_bukgu = new ArraylocalData();
    public static ArraylocalData daegu_dalseo = new ArraylocalData();
    public static ArraylocalData daegu_dalseong = new ArraylocalData();
    public static ArraylocalData daegu_dalseong1 = new ArraylocalData();
    public static ArraylocalData daegu_donggu = new ArraylocalData();
    public static ArraylocalData daegu_junggu = new ArraylocalData();
    public static ArraylocalData daegu_seogu = new ArraylocalData();
    public static ArraylocalData daegu_suseong = new ArraylocalData();
    public static ArraylocalData daegu_namgu = new ArraylocalData();
    public static ArraylocalData ulsan_all = new ArraylocalData();
    public static ArraylocalData ulsan_bukgu = new ArraylocalData();
    public static ArraylocalData ulsan_donggu = new ArraylocalData();
    public static ArraylocalData ulsan_junggu = new ArraylocalData();
    public static ArraylocalData ulsan_namgu = new ArraylocalData();
    public static ArraylocalData ulsan_ulju = new ArraylocalData();
    public static ArraylocalData jeonbuk_all = new ArraylocalData();
    public static ArraylocalData jeonbuk_buan = new ArraylocalData();
    public static ArraylocalData jeonbuk_gimje = new ArraylocalData();
    public static ArraylocalData jeonbuk_gochang = new ArraylocalData();
    public static ArraylocalData jeonbuk_gunsan = new ArraylocalData();
    public static ArraylocalData jeonbuk_iksan = new ArraylocalData();
    public static ArraylocalData jeonbuk_imsil = new ArraylocalData();
    public static ArraylocalData jeonbuk_jangsu = new ArraylocalData();
    public static ArraylocalData jeonbuk_jeongeup = new ArraylocalData();
    public static ArraylocalData jeonbuk_jeonju = new ArraylocalData();
    public static ArraylocalData jeonbuk_jinan = new ArraylocalData();
    public static ArraylocalData jeonbuk_muju = new ArraylocalData();
    public static ArraylocalData jeonbuk_namwon = new ArraylocalData();
    public static ArraylocalData jeonbuk_sunchang = new ArraylocalData();
    public static ArraylocalData jeonbuk_finish = new ArraylocalData();
    public static ArraylocalData gyungnam_all = new ArraylocalData();
    public static ArraylocalData gyungnam_changnyeong = new ArraylocalData();
    public static ArraylocalData gyungnam_changwon = new ArraylocalData();
    public static ArraylocalData gyungnam_geochang = new ArraylocalData();
    public static ArraylocalData gyungnam_geoje = new ArraylocalData();
    public static ArraylocalData gyungnam_gimhae = new ArraylocalData();
    public static ArraylocalData gyungnam_goseong = new ArraylocalData();
    public static ArraylocalData gyungnam_hadong = new ArraylocalData();
    public static ArraylocalData gyungnam_haman = new ArraylocalData();
    public static ArraylocalData gyungnam_hamyang = new ArraylocalData();
    public static ArraylocalData gyungnam_hapcheon = new ArraylocalData();
    public static ArraylocalData gyungnam_jinju = new ArraylocalData();
    public static ArraylocalData gyungnam_miryang = new ArraylocalData();
    public static ArraylocalData gyungnam_namhae = new ArraylocalData();
    public static ArraylocalData gyungnam_sacheon = new ArraylocalData();
    public static ArraylocalData gyungnam_sancheong = new ArraylocalData();
    public static ArraylocalData gyungnam_tongyeong = new ArraylocalData();
    public static ArraylocalData gyungnam_uiryeong = new ArraylocalData();
    public static ArraylocalData gyungnam_yangsan = new ArraylocalData();
    public static ArraylocalData busan_all = new ArraylocalData();
    public static ArraylocalData busan_bukgu = new ArraylocalData();
    public static ArraylocalData busan_donggu = new ArraylocalData();
    public static ArraylocalData busan_dongnae = new ArraylocalData();
    public static ArraylocalData busan_gangseo = new ArraylocalData();
    public static ArraylocalData busan_geumjeong = new ArraylocalData();
    public static ArraylocalData busan_gijang = new ArraylocalData();
    public static ArraylocalData busan_haeundae = new ArraylocalData();
    public static ArraylocalData busan_jingu = new ArraylocalData();
    public static ArraylocalData busan_junggu = new ArraylocalData();
    public static ArraylocalData busan_namgu = new ArraylocalData();
    public static ArraylocalData busan_saha = new ArraylocalData();
    public static ArraylocalData busan_sasang = new ArraylocalData();
    public static ArraylocalData busan_seogu = new ArraylocalData();
    public static ArraylocalData busan_suyeong = new ArraylocalData();
    public static ArraylocalData busan_yeongdo = new ArraylocalData();
    public static ArraylocalData busan_yeonje = new ArraylocalData();
    public static ArraylocalData jeonnam_all = new ArraylocalData();
    public static ArraylocalData jeonnam_boseong = new ArraylocalData();
    public static ArraylocalData jeonnam_damyang = new ArraylocalData();
    public static ArraylocalData jeonnam_gangjin = new ArraylocalData();
    public static ArraylocalData jeonnam_goheung = new ArraylocalData();
    public static ArraylocalData jeonnam_gokseong = new ArraylocalData();
    public static ArraylocalData jeonnam_gurye = new ArraylocalData();
    public static ArraylocalData jeonnam_gwangyang = new ArraylocalData();
    public static ArraylocalData jeonnam_haenam = new ArraylocalData();
    public static ArraylocalData jeonnam_hampyeong = new ArraylocalData();
    public static ArraylocalData jeonnam_hwasun = new ArraylocalData();
    public static ArraylocalData jeonnam_jangheung = new ArraylocalData();
    public static ArraylocalData jeonnam_jangseong = new ArraylocalData();
    public static ArraylocalData jeonnam_jindo = new ArraylocalData();
    public static ArraylocalData jeonnam_mokpo = new ArraylocalData();
    public static ArraylocalData jeonnam_muan = new ArraylocalData();
    public static ArraylocalData jeonnam_naju = new ArraylocalData();
    public static ArraylocalData jeonnam_sinan = new ArraylocalData();
    public static ArraylocalData jeonnam_suncheon = new ArraylocalData();
    public static ArraylocalData jeonnam_wando = new ArraylocalData();
    public static ArraylocalData jeonnam_yeongam = new ArraylocalData();
    public static ArraylocalData jeonnam_yeonggwang = new ArraylocalData();
    public static ArraylocalData jeonnam_yeosu = new ArraylocalData();
    public static ArraylocalData jeju_all = new ArraylocalData();
    public static ArraylocalData jeju_jeju = new ArraylocalData();
    public static ArraylocalData jeju_seogwipo = new ArraylocalData();

//endregion

    //region 솔루션변수선언
    private ArraylocalData soulution_gyunggi_suwon = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_seongnam = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_bucheon = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_changwon = new ArraylocalData();
    private ArraylocalData soulution_seoul_gangnam = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_anyang = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_goyang = new ArraylocalData();
    private ArraylocalData soulution_jeju_jeju = new ArraylocalData();
    private ArraylocalData soulution_chungnam_cheonan = new ArraylocalData();
    private ArraylocalData soulution_seoul_yeongdeungpo = new ArraylocalData();
    private ArraylocalData soulution_busan_jingu = new ArraylocalData();
    private ArraylocalData soulution_seoul_mapo = new ArraylocalData();
    private ArraylocalData soulution_seoul_songpa = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_gimhae = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_hwaseong = new ArraylocalData();
    private ArraylocalData soulution_seoul_gwanak = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_pyeongtaek = new ArraylocalData();
    private ArraylocalData soulution_seoul_guro = new ArraylocalData();
    private ArraylocalData soulution_daegu_dalseo = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_jeonju = new ArraylocalData();
    private ArraylocalData soulution_seoul_gangseo = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_uijeongbu = new ArraylocalData();
    private ArraylocalData soulution_daejeon_seogu = new ArraylocalData();
    private ArraylocalData soulution_seoul_seocho = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_namyangju = new ArraylocalData();
    private ArraylocalData soulution_seoul_jungnang = new ArraylocalData();
    private ArraylocalData soulution_seoul_junggu = new ArraylocalData();
    private ArraylocalData soulution_seoul_dongdaemun = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_siheung = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_pohang = new ArraylocalData();
    private ArraylocalData soulution_seoul_jongno = new ArraylocalData();
    private ArraylocalData soulution_ulsan_namgu = new ArraylocalData();
    private ArraylocalData soulution_seoul_nowon = new ArraylocalData();
    private ArraylocalData soulution_seoul_eunpyeong = new ArraylocalData();
    private ArraylocalData soulution_seoul_gangdong = new ArraylocalData();
    private ArraylocalData soulution_gangwon_wonju = new ArraylocalData();
    private ArraylocalData soulution_seoul_gangbuk = new ArraylocalData();
    private ArraylocalData soulution_gwangju_bukgu = new ArraylocalData();
    private ArraylocalData soulution_seoul_yangchun = new ArraylocalData();
    private ArraylocalData soulution_seoul_geumcheon = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_gumi = new ArraylocalData();
    private ArraylocalData soulution_seoul_seongbuk = new ArraylocalData();
    private ArraylocalData soulution_busan_haeundae = new ArraylocalData();
    private ArraylocalData soulution_seoul_seodaemun = new ArraylocalData();
    private ArraylocalData soulution_daejeon_junggu = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_jinju = new ArraylocalData();
    private ArraylocalData soulution_daegu_donggu = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_paju = new ArraylocalData();
    private ArraylocalData soulution_daegu_suseong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_gwangmyeong = new ArraylocalData();
    private ArraylocalData soulution_gwangju_gwangsan = new ArraylocalData();
    private ArraylocalData soulution_seoul_dongjak = new ArraylocalData();
    private ArraylocalData soulution_seoul_seongdong = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_mokpo = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_yeosu = new ArraylocalData();
    private ArraylocalData soulution_gangwon_chuncheon = new ArraylocalData();
    private ArraylocalData soulution_daejeon_donggu = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_gyeongsan = new ArraylocalData();
    private ArraylocalData soulution_chungnam_asan = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_geoje = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_iksan = new ArraylocalData();
    private ArraylocalData soulution_busan_saha = new ArraylocalData();
    private ArraylocalData soulution_jeju_seogwipo = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_gunsan = new ArraylocalData();
    private ArraylocalData soulution_daejeon_yuseong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_gwangju = new ArraylocalData();
    private ArraylocalData soulution_incheon_bupyeong = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_suncheon = new ArraylocalData();
    private ArraylocalData soulution_busan_dongnae = new ArraylocalData();
    private ArraylocalData soulution_busan_sasang = new ArraylocalData();
    private ArraylocalData soulution_busan_bukgu = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_guri = new ArraylocalData();
    private ArraylocalData soulution_daegu_seogu = new ArraylocalData();
    private ArraylocalData soulution_seoul_dobong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_gimpo = new ArraylocalData();
    private ArraylocalData soulution_busan_namgu = new ArraylocalData();
    private ArraylocalData soulution_daegu_junggu = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_gunpo = new ArraylocalData();
    private ArraylocalData soulution_ulsan_donggu = new ArraylocalData();
    private ArraylocalData soulution_busan_geumjeong = new ArraylocalData();
    private ArraylocalData soulution_incheon_namgu = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_icheon = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_osan = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_chungju = new ArraylocalData();
    private ArraylocalData soulution_daegu_namgu = new ArraylocalData();
    private ArraylocalData soulution_busan_junggu = new ArraylocalData();
    private ArraylocalData soulution_gwangju_namgu = new ArraylocalData();
    private ArraylocalData soulution_daejeon_daedeok = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_yangju = new ArraylocalData();
    private ArraylocalData soulution_chungnam_sejong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_pocheon = new ArraylocalData();
    private ArraylocalData soulution_ulsan_ulju = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_andong = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_tongyeong = new ArraylocalData();
    private ArraylocalData soulution_busan_suyeong = new ArraylocalData();
    private ArraylocalData soulution_busan_seogu = new ArraylocalData();
    private ArraylocalData soulution_chungnam_dangjin = new ArraylocalData();
    private ArraylocalData soulution_daegu_dalseong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_hanam = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_jecheon = new ArraylocalData();
    private ArraylocalData soulution_busan_gijang = new ArraylocalData();
    private ArraylocalData soulution_incheon_gyeyang = new ArraylocalData();
    private ArraylocalData soulution_busan_gangseo = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_gwangyang = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_dongducheon = new ArraylocalData();
    private ArraylocalData soulution_ulsan_bukgu = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_chilgok = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_eumseong = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_miryang = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_sacheon = new ArraylocalData();
    private ArraylocalData soulution_chungnam_boryeong = new ArraylocalData();
    private ArraylocalData soulution_chungnam_nonsan = new ArraylocalData();
    private ArraylocalData soulution_incheon_yeonsu = new ArraylocalData();
    private ArraylocalData soulution_gangwon_donghae = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_yeongcheon = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_yangpyeong = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_jeongeup = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_uiwang = new ArraylocalData();
    private ArraylocalData soulution_gangwon_samcheok = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_jincheon = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_yeongju = new ArraylocalData();
    private ArraylocalData soulution_chungnam_hongseong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_gapyeong = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_namwon = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_sangju = new ArraylocalData();
    private ArraylocalData soulution_chungnam_yesan = new ArraylocalData();
    private ArraylocalData soulution_gangwon_hongcheon = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_haenam = new ArraylocalData();
    private ArraylocalData soulution_chungnam_taean = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_mungyeong = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_sinan = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_muan = new ArraylocalData();
    private ArraylocalData soulution_incheon_junggu = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_goseong = new ArraylocalData();
    private ArraylocalData soulution_gangwon_taebaek = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_yeongam = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_gwacheon = new ArraylocalData();
    private ArraylocalData soulution_chungnam_buyeo = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_haman = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_hwasun = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_wando = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_jangseong = new ArraylocalData();
    private ArraylocalData soulution_gyunggi_yeoncheon = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_buan = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_seongju = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_boseong = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_okcheon = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_hadong = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_cheongdo = new ArraylocalData();
    private ArraylocalData soulution_chungnam_seocheon = new ArraylocalData();
    private ArraylocalData soulution_gangwon_hoengseong = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_uljin = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_yeongdong = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_danyang = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_hamyang = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_namhae = new ArraylocalData();
    private ArraylocalData soulution_chungbuk_boeun = new ArraylocalData();
    private ArraylocalData soulution_gangwon_yeongwol = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_sancheong = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_yecheon = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_gurye = new ArraylocalData();
    private ArraylocalData soulution_gangwon_inje = new ArraylocalData();
    private ArraylocalData soulution_jeonnam_gokseong = new ArraylocalData();
    private ArraylocalData soulution_gyungnam_uiryeong = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_cheongsong = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_muju = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_imsil = new ArraylocalData();
    private ArraylocalData soulution_gyeongbuk_bonghwa = new ArraylocalData();
    private ArraylocalData soulution_gangwon_yanggu = new ArraylocalData();
    private ArraylocalData soulution_jeonbuk_sunchang = new ArraylocalData();

    //endregion
    public static ArrayList<ArraylocalData> arraylocalData = new ArrayList<ArraylocalData>();
    public static ArrayList<ArraylocalData> solution_arraylocalData = new ArrayList<ArraylocalData>();
    Socket socket;
    InputStream is;
    OutputStream os;

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);

    private String RecvData = "";
    private String AllData = "";
    private String Solutiondata = "";

    private Button btn_result;
    private Button btn_ccc;
    private Button btn_ddd;
    private Button btn_aaa;
    Animation animationfadein;
    Animation animationfadeout;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        btn_result = (Button)findViewById(R.id.btn_result);

        btn_ccc = (Button)findViewById(R.id.btn_ccc);
        btn_ddd= (Button)findViewById(R.id.btn_ddd);
        btn_aaa= (Button)findViewById(R.id.btn_aaa);
        animationfadein = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        animationfadeout = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn_ccc.getVisibility() ==view.GONE && btn_ddd.getVisibility() ==view.GONE&& btn_aaa.getVisibility() ==view.GONE) {
                    btn_ccc.setVisibility(view.VISIBLE);
                    btn_ccc.startAnimation(animationfadein);
                    btn_ddd.setVisibility(view.VISIBLE);
                    btn_ddd.startAnimation(animationfadein);
                    btn_aaa.setVisibility(view.VISIBLE);
                    btn_aaa.startAnimation(animationfadein);
                } else {
                    btn_ccc.setVisibility(view.GONE);
                    btn_ccc.startAnimation(animationfadeout);
                    btn_ddd.setVisibility(view.GONE);
                    btn_ddd.startAnimation(animationfadeout);
                    btn_aaa.setVisibility(view.GONE);
                    btn_aaa.startAnimation(animationfadeout);

                }
            }
        });

        init();

        Intent intent = new Intent(this, loding.class);
        startActivity(intent);
    }

    //region 버튼클릭
    public void onClickBusan(View v)
    {
        Intent intent = new Intent(getApplicationContext(), busanactivity.class);
        startActivity(intent);
    }

    public void onClickchungbuk(View v)
    {
        Intent intent = new Intent(getApplicationContext(), chungbukactivity.class);
        startActivity(intent);
    }

    public void onClickGyeonggido(View v)
    {
        Intent intent = new Intent(getApplicationContext(), gyunggiactivity.class);
        startActivity(intent);
    }

    public void onClickSeoul(View v)
    {
        Intent intent = new Intent(getApplicationContext(), seoulactivity.class);
        startActivity(intent);
    }

    public void onClickIncheon(View v)
    {
        Intent intent = new Intent(getApplicationContext(), inchunactivity.class);
        startActivity(intent);
    }

    public void onClickGangwondo(View v)
    {
        Intent intent = new Intent(getApplicationContext(), gangwonactivity.class);
        startActivity(intent);
    }

    public void onClickChungnam(View v)
    {
        Intent intent = new Intent(getApplicationContext(), chungnamactivity.class);
        startActivity(intent);
    }

    public void onClickDaejeon(View v)
    {
        Intent intent = new Intent(getApplicationContext(), daejeonactivity.class);
        startActivity(intent);
    }

    public void onClickDaegu(View v)
    {
        Intent intent = new Intent(getApplicationContext(), daeguactivity.class);
        startActivity(intent);
    }

    public void onClcikUlsan(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ulsanactivity.class);
        startActivity(intent);
    }

    public void onClickGyeongnam(View v)
    {
        Intent intent = new Intent(getApplicationContext(), gyungnamactivity.class);
        startActivity(intent);
    }

    public  void onClickGwangju(View v)
    {
        Intent intent = new Intent(getApplicationContext(), gwangjuactivity.class);
        startActivity(intent);
    }
    public void onClickJeonnam(View v)
    {
        Intent intent = new Intent(getApplicationContext(), jeonnamactivity.class);
        startActivity(intent);
    }

    public void onClickGyeongbuk(View v)
    {
        Intent intent = new Intent(getApplicationContext(), gyungbukactivity.class);
        startActivity(intent);
    }

    public void onClickjeonbuk(View v)
    {
        Intent intent = new Intent(getApplicationContext(), jeonbukactivity.class);
        startActivity(intent);
    }

    public void onClickJejudo(View v)
    {
        Intent intent = new Intent(getApplicationContext(), jejuactivity.class);
        startActivity(intent);
    }

    public void onClickResult2(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Graph3.class);
        startActivity(intent);
    }
    public void onClickResult3(View v)
    {
        Intent intent = new Intent(getApplicationContext(), GraphAll.class);
        startActivity(intent);
    }
    public void onClickResult1(View v)
    {
        Intent intent = new Intent(getApplicationContext(), CompareGraph.class);
        startActivity(intent);
    }

    //endregion

    int byteRead = 0;
    String abc ="";
    int maxsize = 0;

    //region 소켓
    private void receiveMessage(Socket socket) {
        try {

            is = new DataInputStream(socket.getInputStream());

            byte[] bytedata = new byte[4096];

            while(maxsize<15057){
                byteRead = is.read(bytedata);
                byteArrayOutputStream.write(bytedata, 0, byteRead);
                abc = byteArrayOutputStream.toString("UTF-8");

                maxsize += byteRead;
            }



            //String abc = new String(bytedata,"UTF-8");
            abc = abc.trim();
            String aaa = abc;

            RecvData(aaa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Connect_Server(){
        try {

            String str = "First_Data";
            byte[] bytedata = str.getBytes("UTF-8");

            socket = new Socket("192.168.0.25",8000);

            sendMessage(socket,bytedata);
            receiveMessage(socket);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendMessage(Socket socket,byte[] bt) {

        try {

            os = new DataOutputStream(socket.getOutputStream());
            os.write(bt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        Connect_Server();
        Addarraylocaldata();
        AddSolutionarraylocaldata();

        SplitSolutionData(RecvData);
        SplitData(AllData,arraylocalData);
        SplitData(Solutiondata,solution_arraylocalData);
        ArrayAddCapitalandLocal();
    }

    public void RecvData(String data){
        String[] tokens;

        tokens = data.split("#");
        if(tokens[0].equals("R_First_Data")){
            RecvData = tokens[1];
        }
    }
    //endregion

    public void SplitSolutionData(String data){
        String[] tokens;

        tokens = data.split("%");

        AllData = tokens[0];
        Solutiondata = tokens[1];
    }


    public void SplitData(String data,ArrayList<ArraylocalData> localdata){
        String[] tokens;

        tokens = data.split("\\$");

        if(localdata == arraylocalData){
            for(int i = 0;i<tokens.length;i++){
                SplitLocalData(tokens[i],localdata.get(i));
            }
        } else if(localdata == solution_arraylocalData){
            for(int i = 0;i<tokens.length;i++){
                SplitSolutionLocalData(tokens[i],localdata.get(i));
            }
        }


    }

    public void SplitLocalData(String splitdata, ArraylocalData local) {
        String[] tokens;

        tokens = splitdata.split("\\s");
        local.setCctvData(Integer.parseInt(tokens[0]));
        local.setLampData(Integer.parseInt(tokens[1]));
        local.setPopulationData(Integer.parseInt(tokens[2]));
        local.setAreaData(Double.parseDouble(tokens[3]));

        local.setCrimeData(Double.parseDouble(tokens[4]));
    }

    public void SplitSolutionLocalData(String splitdata, ArraylocalData local){
        String[] tokens;

        tokens = splitdata.split("\\s");
        local.setCapitalData(tokens[0]);
        local.setLocalData(tokens[1]);
        local.setCctvData(Integer.parseInt(tokens[2]));
        local.setLampData(Integer.parseInt(tokens[3]));
        local.setPopulationData(Integer.parseInt(tokens[4]));
        local.setCrimeData(Double.parseDouble(tokens[5]));
    }

    public void Addarraylocaldata(){
        arraylocalData.add(seoul_all);
        arraylocalData.add(seoul_dobong);
        arraylocalData.add(seoul_dongdaemun);
        arraylocalData.add(seoul_dongjak);
        arraylocalData.add(seoul_eunpyeong);
        arraylocalData.add(seoul_gangbuk);
        arraylocalData.add(seoul_gangdong);
        arraylocalData.add(seoul_gangnam);
        arraylocalData.add(seoul_gangseo);
        arraylocalData.add(seoul_geumcheon);
        arraylocalData.add(seoul_guro);
        arraylocalData.add(seoul_gwanak);
        arraylocalData.add(seoul_gwangjin);
        arraylocalData.add(seoul_jongno);
        arraylocalData.add(seoul_junggu);
        arraylocalData.add(seoul_jungnang);
        arraylocalData.add(seoul_mapo);
        arraylocalData.add(seoul_nowon);
        arraylocalData.add(seoul_seocho);
        arraylocalData.add(seoul_seodaemun);
        arraylocalData.add(seoul_seongbuk);
        arraylocalData.add(seoul_seongdong);
        arraylocalData.add(seoul_songpa);
        arraylocalData.add(seoul_yangchun);
        arraylocalData.add(seoul_yeongdeungpo);
        arraylocalData.add(seoul_yongsan);
        arraylocalData.add(gyunggi_all);
        arraylocalData.add(gyunggi_ansan);
        arraylocalData.add(gyunggi_anseong);
        arraylocalData.add(gyunggi_anyang);
        arraylocalData.add(gyunggi_bucheon);
        arraylocalData.add(gyunggi_dongducheon);
        arraylocalData.add(gyunggi_gapyeong);
        arraylocalData.add(gyunggi_gimpo);
        arraylocalData.add(gyunggi_goyang);
        arraylocalData.add(gyunggi_gunpo);
        arraylocalData.add(gyunggi_guri);
        arraylocalData.add(gyunggi_gwacheon);
        arraylocalData.add(gyunggi_gwangmyeong);
        arraylocalData.add(gyunggi_gwangju);
        arraylocalData.add(gyunggi_hanam);
        arraylocalData.add(gyunggi_hwaseong);
        arraylocalData.add(gyunggi_icheon);
        arraylocalData.add(gyunggi_namyangju);
        arraylocalData.add(gyunggi_osan);
        arraylocalData.add(gyunggi_paju);
        arraylocalData.add(gyunggi_pocheon);
        arraylocalData.add(gyunggi_pyeongtaek);
        arraylocalData.add(gyunggi_seongnam);
        arraylocalData.add(gyunggi_siheung);
        arraylocalData.add(gyunggi_suwon);
        arraylocalData.add(gyunggi_uijeongbu);
        arraylocalData.add(gyunggi_uiwang);
        arraylocalData.add(gyunggi_yangju);
        arraylocalData.add(gyunggi_yangpyeong);
        arraylocalData.add(gyunggi_yeoju);
        arraylocalData.add(gyunggi_yeoncheon);
        arraylocalData.add(gyunggi_yongin);
        arraylocalData.add(inchun_all);
        arraylocalData.add(inchun_bupyeong);
        arraylocalData.add(inchun_donggu);
        arraylocalData.add(inchun_ganghwa);
        arraylocalData.add(inchun_gyeyang);
        arraylocalData.add(inchun__junggu);
        arraylocalData.add(inchun_namdonggu);
        arraylocalData.add(inchun_namgu);
        arraylocalData.add(inchun_ongjin);
        arraylocalData.add(inchun_seogu);
        arraylocalData.add(inchun_yeonsu);
        arraylocalData.add(gangwon_all);
        arraylocalData.add(gangwon_cheorwon);
        arraylocalData.add(gangwon_chuncheon);
        arraylocalData.add(gangwon_donghae);
        arraylocalData.add(gangwon_gangneung);
        arraylocalData.add(gangwon_goseong);
        arraylocalData.add(gangwon_hoengseong);
        arraylocalData.add(gangwon_hongcheon);
        arraylocalData.add(gangwon_hwacheon);
        arraylocalData.add(gangwon_inje);
        arraylocalData.add(gangwon_jeongseon);
        arraylocalData.add(gangwon_pyeongchang);
        arraylocalData.add(gangwon_samcheok);
        arraylocalData.add(gangwon_sokcho);
        arraylocalData.add(gangwon_taebaek);
        arraylocalData.add(gangwon_wonju);
        arraylocalData.add(gangwon_yanggu);
        arraylocalData.add(gangwon_yangyang);
        arraylocalData.add(gangwon_yeongwol);
        arraylocalData.add(gwangju_all);
        arraylocalData.add(gwangju_bukgu);
        arraylocalData.add(gwangju_donggu);
        arraylocalData.add(gwangju_gwangsan);
        arraylocalData.add(gwangju_namgu);
        arraylocalData.add(gwangju_seogu);
        arraylocalData.add(chungnam_all);
        arraylocalData.add(chungnam_asan);
        arraylocalData.add(chungnam_boryeong);
        arraylocalData.add(chungnam_buyeo);
        arraylocalData.add(chungnam_cheonan);
        arraylocalData.add(chungnam_cheongyang);
        arraylocalData.add(chungnam_dangjin);
        arraylocalData.add(chungnam_geumsan);
        arraylocalData.add(chungnam_gongju);
        arraylocalData.add(chungnam_gyeryong);
        arraylocalData.add(chungnam_hongseong);
        arraylocalData.add(chungnam_nonsan);
        arraylocalData.add(chungnam_sejong);
        arraylocalData.add(chungnam_seocheon);
        arraylocalData.add(chungnam_seosan);
        arraylocalData.add(chungnam_taean);
        arraylocalData.add(chungnam_yesan);
        arraylocalData.add(chungbuk_all);
        arraylocalData.add(chungbuk_boeun);
        arraylocalData.add(chungbuk_cheongju);
        arraylocalData.add(chungbuk_chungju);
        arraylocalData.add(chungbuk_danyang);
        arraylocalData.add(chungbuk_eumseong);
        arraylocalData.add(chungbuk_goesan);
        arraylocalData.add(chungbuk_jecheon);
        arraylocalData.add(chungbuk_jeungpyeong);
        arraylocalData.add(chungbuk_jincheon);
        arraylocalData.add(chungbuk_okcheon);
        arraylocalData.add(chungbuk_yeongdong);
        arraylocalData.add(daejeon_all);
        arraylocalData.add(daejeon_daedeok);
        arraylocalData.add(daejeon_donggu);
        arraylocalData.add(daejeon_junggu);
        arraylocalData.add(daejeon_seogu);
        arraylocalData.add(daejeon_yuseong);
        arraylocalData.add(gyungbuk_all);
        arraylocalData.add(gyungbuk_andong);
        arraylocalData.add(gyungbuk_bonghwa);
        arraylocalData.add(gyungbuk_cheongdo);
        arraylocalData.add(gyungbuk_cheongsong);
        arraylocalData.add(gyungbuk_chilgok);
        arraylocalData.add(gyungbuk_gimcheon);
        arraylocalData.add(gyungbuk_goryeong);
        arraylocalData.add(gyungbuk_gumi);
        arraylocalData.add(gyungbuk_gunwi);
        arraylocalData.add(gyungbuk_gyeongju);
        arraylocalData.add(gyungbuk_gyeongsan);
        arraylocalData.add(gyungbuk_mungyeong);
        arraylocalData.add(gyungbuk_pohang);
        arraylocalData.add(gyungbuk_sangju);
        arraylocalData.add(gyungbuk_seongju);
        arraylocalData.add(gyungbuk_uiseong);
        arraylocalData.add(gyungbuk_uljin);
        arraylocalData.add(gyungbuk_yecheon);
        arraylocalData.add(gyungbuk_yeongcheon);
        arraylocalData.add(gyungbuk_yeongdeok);
        arraylocalData.add(gyungbuk_yeongju);
        arraylocalData.add(gyungbuk_yeongyang);
        arraylocalData.add(daegu_all);
        arraylocalData.add(daegu_bukgu);
        arraylocalData.add(daegu_dalseo);
        arraylocalData.add(daegu_dalseong);
        arraylocalData.add(daegu_dalseong1);
        arraylocalData.add(daegu_donggu);
        arraylocalData.add(daegu_junggu);
        arraylocalData.add(daegu_seogu);
        arraylocalData.add(daegu_suseong);
        arraylocalData.add(daegu_namgu);
        arraylocalData.add(ulsan_all);
        arraylocalData.add(ulsan_bukgu);
        arraylocalData.add(ulsan_donggu);
        arraylocalData.add(ulsan_junggu);
        arraylocalData.add(ulsan_namgu);
        arraylocalData.add(ulsan_ulju);
        arraylocalData.add(jeonbuk_all);
        arraylocalData.add(jeonbuk_buan);
        arraylocalData.add(jeonbuk_gimje);
        arraylocalData.add(jeonbuk_gochang);
        arraylocalData.add(jeonbuk_gunsan);
        arraylocalData.add(jeonbuk_iksan);
        arraylocalData.add(jeonbuk_imsil);
        arraylocalData.add(jeonbuk_jangsu);
        arraylocalData.add(jeonbuk_jeongeup);
        arraylocalData.add(jeonbuk_jeonju);
        arraylocalData.add(jeonbuk_jinan);
        arraylocalData.add(jeonbuk_muju);
        arraylocalData.add(jeonbuk_namwon);
        arraylocalData.add(jeonbuk_sunchang);
        arraylocalData.add(jeonbuk_finish);
        arraylocalData.add(gyungnam_all);
        arraylocalData.add(gyungnam_changnyeong);
        arraylocalData.add(gyungnam_changwon);
        arraylocalData.add(gyungnam_geochang);
        arraylocalData.add(gyungnam_geoje);
        arraylocalData.add(gyungnam_gimhae);
        arraylocalData.add(gyungnam_goseong);
        arraylocalData.add(gyungnam_hadong);
        arraylocalData.add(gyungnam_haman);
        arraylocalData.add(gyungnam_hamyang);
        arraylocalData.add(gyungnam_hapcheon);
        arraylocalData.add(gyungnam_jinju);
        arraylocalData.add(gyungnam_miryang);
        arraylocalData.add(gyungnam_namhae);
        arraylocalData.add(gyungnam_sacheon);
        arraylocalData.add(gyungnam_sancheong);
        arraylocalData.add(gyungnam_tongyeong);
        arraylocalData.add(gyungnam_uiryeong);
        arraylocalData.add(gyungnam_yangsan);
        arraylocalData.add(busan_all);
        arraylocalData.add(busan_bukgu);
        arraylocalData.add(busan_donggu);
        arraylocalData.add(busan_dongnae);
        arraylocalData.add(busan_gangseo);
        arraylocalData.add(busan_geumjeong);
        arraylocalData.add(busan_gijang);
        arraylocalData.add(busan_haeundae);
        arraylocalData.add(busan_jingu);
        arraylocalData.add(busan_junggu);
        arraylocalData.add(busan_namgu);
        arraylocalData.add(busan_saha);
        arraylocalData.add(busan_sasang);
        arraylocalData.add(busan_seogu);
        arraylocalData.add(busan_suyeong);
        arraylocalData.add(busan_yeongdo);
        arraylocalData.add(busan_yeonje);
        arraylocalData.add(jeonnam_all);
        arraylocalData.add(jeonnam_boseong);
        arraylocalData.add(jeonnam_damyang);
        arraylocalData.add(jeonnam_gangjin);
        arraylocalData.add(jeonnam_goheung);
        arraylocalData.add(jeonnam_gokseong);
        arraylocalData.add(jeonnam_gurye);
        arraylocalData.add(jeonnam_gwangyang);
        arraylocalData.add(jeonnam_haenam);
        arraylocalData.add(jeonnam_hampyeong);
        arraylocalData.add(jeonnam_hwasun);
        arraylocalData.add(jeonnam_jangheung);
        arraylocalData.add(jeonnam_jangseong);
        arraylocalData.add(jeonnam_jindo);
        arraylocalData.add(jeonnam_mokpo);
        arraylocalData.add(jeonnam_muan);
        arraylocalData.add(jeonnam_naju);
        arraylocalData.add(jeonnam_sinan);
        arraylocalData.add(jeonnam_suncheon);
        arraylocalData.add(jeonnam_wando);
        arraylocalData.add(jeonnam_yeongam);
        arraylocalData.add(jeonnam_yeonggwang);
        arraylocalData.add(jeonnam_yeosu);
        arraylocalData.add(jeju_all);
        arraylocalData.add(jeju_jeju);
        arraylocalData.add(jeju_seogwipo);

    }

    public void AddSolutionarraylocaldata(){
        solution_arraylocalData.add(soulution_gyunggi_suwon);
        solution_arraylocalData.add(soulution_gyunggi_seongnam);
        solution_arraylocalData.add(soulution_gyunggi_bucheon);
        solution_arraylocalData.add(soulution_gyungnam_changwon);
        solution_arraylocalData.add(soulution_seoul_gangnam);
        solution_arraylocalData.add(soulution_gyunggi_anyang);
        solution_arraylocalData.add(soulution_gyunggi_goyang);
        solution_arraylocalData.add(soulution_jeju_jeju);
        solution_arraylocalData.add(soulution_chungnam_cheonan);
        solution_arraylocalData.add(soulution_seoul_yeongdeungpo);
        solution_arraylocalData.add(soulution_busan_jingu);
        solution_arraylocalData.add(soulution_seoul_mapo);
        solution_arraylocalData.add(soulution_seoul_songpa);
        solution_arraylocalData.add(soulution_gyungnam_gimhae);
        solution_arraylocalData.add(soulution_gyunggi_hwaseong);
        solution_arraylocalData.add(soulution_seoul_gwanak);
        solution_arraylocalData.add(soulution_gyunggi_pyeongtaek);
        solution_arraylocalData.add(soulution_seoul_guro);
        solution_arraylocalData.add(soulution_daegu_dalseo);
        solution_arraylocalData.add(soulution_jeonbuk_jeonju);
        solution_arraylocalData.add(soulution_seoul_gangseo);
        solution_arraylocalData.add(soulution_gyunggi_uijeongbu);
        solution_arraylocalData.add(soulution_daejeon_seogu);
        solution_arraylocalData.add(soulution_seoul_seocho);
        solution_arraylocalData.add(soulution_gyunggi_namyangju);
        solution_arraylocalData.add(soulution_seoul_jungnang);
        solution_arraylocalData.add(soulution_seoul_junggu);
        solution_arraylocalData.add(soulution_seoul_dongdaemun);
        solution_arraylocalData.add(soulution_gyunggi_siheung);
        solution_arraylocalData.add(soulution_gyeongbuk_pohang);
        solution_arraylocalData.add(soulution_seoul_jongno);
        solution_arraylocalData.add(soulution_ulsan_namgu);
        solution_arraylocalData.add(soulution_seoul_nowon);
        solution_arraylocalData.add(soulution_seoul_eunpyeong);
        solution_arraylocalData.add(soulution_seoul_gangdong);
        solution_arraylocalData.add(soulution_gangwon_wonju);
        solution_arraylocalData.add(soulution_seoul_gangbuk);
        solution_arraylocalData.add(soulution_gwangju_bukgu);
        solution_arraylocalData.add(soulution_seoul_yangchun);
        solution_arraylocalData.add(soulution_seoul_geumcheon);
        solution_arraylocalData.add(soulution_gyeongbuk_gumi);
        solution_arraylocalData.add(soulution_seoul_seongbuk);
        solution_arraylocalData.add(soulution_busan_haeundae);
        solution_arraylocalData.add(soulution_seoul_seodaemun);
        solution_arraylocalData.add(soulution_daejeon_junggu);
        solution_arraylocalData.add(soulution_gyungnam_jinju);
        solution_arraylocalData.add(soulution_daegu_donggu);
        solution_arraylocalData.add(soulution_gyunggi_paju);
        solution_arraylocalData.add(soulution_daegu_suseong);
        solution_arraylocalData.add(soulution_gyunggi_gwangmyeong);
        solution_arraylocalData.add(soulution_gwangju_gwangsan);
        solution_arraylocalData.add(soulution_seoul_dongjak);
        solution_arraylocalData.add(soulution_seoul_seongdong);
        solution_arraylocalData.add(soulution_jeonnam_mokpo);
        solution_arraylocalData.add(soulution_jeonnam_yeosu);
        solution_arraylocalData.add(soulution_gangwon_chuncheon);
        solution_arraylocalData.add(soulution_daejeon_donggu);
        solution_arraylocalData.add(soulution_gyeongbuk_gyeongsan);
        solution_arraylocalData.add(soulution_chungnam_asan);
        solution_arraylocalData.add(soulution_gyungnam_geoje);
        solution_arraylocalData.add(soulution_jeonbuk_iksan);
        solution_arraylocalData.add(soulution_busan_saha);
        solution_arraylocalData.add(soulution_jeju_seogwipo);
        solution_arraylocalData.add(soulution_jeonbuk_gunsan);
        solution_arraylocalData.add(soulution_daejeon_yuseong);
        solution_arraylocalData.add(soulution_gyunggi_gwangju);
        solution_arraylocalData.add(soulution_incheon_bupyeong);
        solution_arraylocalData.add(soulution_jeonnam_suncheon);
        solution_arraylocalData.add(soulution_busan_dongnae);
        solution_arraylocalData.add(soulution_busan_sasang);
        solution_arraylocalData.add(soulution_busan_bukgu);
        solution_arraylocalData.add(soulution_gyunggi_guri);
        solution_arraylocalData.add(soulution_daegu_seogu);
        solution_arraylocalData.add(soulution_seoul_dobong);
        solution_arraylocalData.add(soulution_gyunggi_gimpo);
        solution_arraylocalData.add(soulution_busan_namgu);
        solution_arraylocalData.add(soulution_daegu_junggu);
        solution_arraylocalData.add(soulution_gyunggi_gunpo);
        solution_arraylocalData.add(soulution_ulsan_donggu);
        solution_arraylocalData.add(soulution_busan_geumjeong);
        solution_arraylocalData.add(soulution_incheon_namgu);
        solution_arraylocalData.add(soulution_gyunggi_icheon);
        solution_arraylocalData.add(soulution_gyunggi_osan);
        solution_arraylocalData.add(soulution_chungbuk_chungju);
        solution_arraylocalData.add(soulution_daegu_namgu);
        solution_arraylocalData.add(soulution_busan_junggu);
        solution_arraylocalData.add(soulution_gwangju_namgu);
        solution_arraylocalData.add(soulution_daejeon_daedeok);
        solution_arraylocalData.add(soulution_gyunggi_yangju);
        solution_arraylocalData.add(soulution_chungnam_sejong);
        solution_arraylocalData.add(soulution_gyunggi_pocheon);
        solution_arraylocalData.add(soulution_ulsan_ulju);
        solution_arraylocalData.add(soulution_gyeongbuk_andong);
        solution_arraylocalData.add(soulution_gyungnam_tongyeong);
        solution_arraylocalData.add(soulution_busan_suyeong);
        solution_arraylocalData.add(soulution_busan_seogu);
        solution_arraylocalData.add(soulution_chungnam_dangjin);
        solution_arraylocalData.add(soulution_daegu_dalseong);
        solution_arraylocalData.add(soulution_gyunggi_hanam);
        solution_arraylocalData.add(soulution_chungbuk_jecheon);
        solution_arraylocalData.add(soulution_busan_gijang);
        solution_arraylocalData.add(soulution_incheon_gyeyang);
        solution_arraylocalData.add(soulution_busan_gangseo);
        solution_arraylocalData.add(soulution_jeonnam_gwangyang);
        solution_arraylocalData.add(soulution_gyunggi_dongducheon);
        solution_arraylocalData.add(soulution_ulsan_bukgu);
        solution_arraylocalData.add(soulution_gyeongbuk_chilgok);
        solution_arraylocalData.add(soulution_chungbuk_eumseong);
        solution_arraylocalData.add(soulution_gyungnam_miryang);
        solution_arraylocalData.add(soulution_gyungnam_sacheon);
        solution_arraylocalData.add(soulution_chungnam_boryeong);
        solution_arraylocalData.add(soulution_chungnam_nonsan);
        solution_arraylocalData.add(soulution_incheon_yeonsu);
        solution_arraylocalData.add(soulution_gangwon_donghae);
        solution_arraylocalData.add(soulution_gyeongbuk_yeongcheon);
        solution_arraylocalData.add(soulution_gyunggi_yangpyeong);
        solution_arraylocalData.add(soulution_jeonbuk_jeongeup);
        solution_arraylocalData.add(soulution_gyunggi_uiwang);
        solution_arraylocalData.add(soulution_gangwon_samcheok);
        solution_arraylocalData.add(soulution_chungbuk_jincheon);
        solution_arraylocalData.add(soulution_gyeongbuk_yeongju);
        solution_arraylocalData.add(soulution_chungnam_hongseong);
        solution_arraylocalData.add(soulution_gyunggi_gapyeong);
        solution_arraylocalData.add(soulution_jeonbuk_namwon);
        solution_arraylocalData.add(soulution_gyeongbuk_sangju);
        solution_arraylocalData.add(soulution_chungnam_yesan);
        solution_arraylocalData.add(soulution_gangwon_hongcheon);
        solution_arraylocalData.add(soulution_jeonnam_haenam);
        solution_arraylocalData.add(soulution_chungnam_taean);
        solution_arraylocalData.add(soulution_gyeongbuk_mungyeong);
        solution_arraylocalData.add(soulution_jeonnam_sinan);
        solution_arraylocalData.add(soulution_jeonnam_muan);
        solution_arraylocalData.add(soulution_incheon_junggu);
        solution_arraylocalData.add(soulution_gyungnam_goseong);
        solution_arraylocalData.add(soulution_gangwon_taebaek);
        solution_arraylocalData.add(soulution_jeonnam_yeongam);
        solution_arraylocalData.add(soulution_gyunggi_gwacheon);
        solution_arraylocalData.add(soulution_chungnam_buyeo);
        solution_arraylocalData.add(soulution_gyungnam_haman);
        solution_arraylocalData.add(soulution_jeonnam_hwasun);
        solution_arraylocalData.add(soulution_jeonnam_wando);
        solution_arraylocalData.add(soulution_jeonnam_jangseong);
        solution_arraylocalData.add(soulution_gyunggi_yeoncheon);
        solution_arraylocalData.add(soulution_jeonbuk_buan);
        solution_arraylocalData.add(soulution_gyeongbuk_seongju);
        solution_arraylocalData.add(soulution_jeonnam_boseong);
        solution_arraylocalData.add(soulution_chungbuk_okcheon);
        solution_arraylocalData.add(soulution_gyungnam_hadong);
        solution_arraylocalData.add(soulution_gyeongbuk_cheongdo);
        solution_arraylocalData.add(soulution_chungnam_seocheon);
        solution_arraylocalData.add(soulution_gangwon_hoengseong);
        solution_arraylocalData.add(soulution_gyeongbuk_uljin);
        solution_arraylocalData.add(soulution_chungbuk_yeongdong);
        solution_arraylocalData.add(soulution_chungbuk_danyang);
        solution_arraylocalData.add(soulution_gyungnam_hamyang);
        solution_arraylocalData.add(soulution_gyungnam_namhae);
        solution_arraylocalData.add(soulution_chungbuk_boeun);
        solution_arraylocalData.add(soulution_gangwon_yeongwol);
        solution_arraylocalData.add(soulution_gyungnam_sancheong);
        solution_arraylocalData.add(soulution_gyeongbuk_yecheon);
        solution_arraylocalData.add(soulution_jeonnam_gurye);
        solution_arraylocalData.add(soulution_gangwon_inje);
        solution_arraylocalData.add(soulution_jeonnam_gokseong);
        solution_arraylocalData.add(soulution_gyungnam_uiryeong);
        solution_arraylocalData.add(soulution_gyeongbuk_cheongsong);
        solution_arraylocalData.add(soulution_jeonbuk_muju);
        solution_arraylocalData.add(soulution_jeonbuk_imsil);
        solution_arraylocalData.add(soulution_gyeongbuk_bonghwa);
        solution_arraylocalData.add(soulution_gangwon_yanggu);
        solution_arraylocalData.add(soulution_jeonbuk_sunchang);



    }

    public void ArrayAddCapitalandLocal(){

        seoul_all.setCapitalData("서울특별시");
        seoul_dobong.setCapitalData("서울특별시");
        seoul_dongdaemun.setCapitalData("서울특별시");
        seoul_dongjak.setCapitalData("서울특별시");
        seoul_eunpyeong.setCapitalData("서울특별시");
        seoul_gangbuk.setCapitalData("서울특별시");
        seoul_gangdong.setCapitalData("서울특별시");
        seoul_gangnam.setCapitalData("서울특별시");
        seoul_gangseo.setCapitalData("서울특별시");
        seoul_geumcheon.setCapitalData("서울특별시");
        seoul_guro.setCapitalData("서울특별시");
        seoul_gwanak.setCapitalData("서울특별시");
        seoul_gwangjin.setCapitalData("서울특별시");
        seoul_jongno.setCapitalData("서울특별시");
        seoul_junggu.setCapitalData("서울특별시");
        seoul_jungnang.setCapitalData("서울특별시");
        seoul_mapo.setCapitalData("서울특별시");
        seoul_nowon.setCapitalData("서울특별시");
        seoul_seocho.setCapitalData("서울특별시");
        seoul_seodaemun.setCapitalData("서울특별시");
        seoul_seongbuk.setCapitalData("서울특별시");
        seoul_seongdong.setCapitalData("서울특별시");
        seoul_songpa.setCapitalData("서울특별시");
        seoul_yangchun.setCapitalData("서울특별시");
        seoul_yeongdeungpo.setCapitalData("서울특별시");
        seoul_yongsan.setCapitalData("서울특별시");
        gyunggi_all.setCapitalData("경기도");
        gyunggi_ansan.setCapitalData("경기도");
        gyunggi_anseong.setCapitalData("경기도");
        gyunggi_anyang.setCapitalData("경기도");
        gyunggi_bucheon.setCapitalData("경기도");
        gyunggi_dongducheon.setCapitalData("경기도");
        gyunggi_gapyeong.setCapitalData("경기도");
        gyunggi_gimpo.setCapitalData("경기도");
        gyunggi_goyang.setCapitalData("경기도");
        gyunggi_gunpo.setCapitalData("경기도");
        gyunggi_guri.setCapitalData("경기도");
        gyunggi_gwacheon.setCapitalData("경기도");
        gyunggi_gwangmyeong.setCapitalData("경기도");
        gyunggi_gwangju.setCapitalData("경기도");
        gyunggi_hanam.setCapitalData("경기도");
        gyunggi_hwaseong.setCapitalData("경기도");
        gyunggi_icheon.setCapitalData("경기도");
        gyunggi_namyangju.setCapitalData("경기도");
        gyunggi_osan.setCapitalData("경기도");
        gyunggi_paju.setCapitalData("경기도");
        gyunggi_pocheon.setCapitalData("경기도");
        gyunggi_pyeongtaek.setCapitalData("경기도");
        gyunggi_seongnam.setCapitalData("경기도");
        gyunggi_siheung.setCapitalData("경기도");
        gyunggi_suwon.setCapitalData("경기도");
        gyunggi_uijeongbu.setCapitalData("경기도");
        gyunggi_uiwang.setCapitalData("경기도");
        gyunggi_yangju.setCapitalData("경기도");
        gyunggi_yangpyeong.setCapitalData("경기도");
        gyunggi_yeoju.setCapitalData("경기도");
        gyunggi_yeoncheon.setCapitalData("경기도");
        gyunggi_yongin.setCapitalData("경기도");
        inchun_all.setCapitalData("인천광역시");
        inchun_bupyeong.setCapitalData("인천광역시");
        inchun_donggu.setCapitalData("인천광역시");
        inchun_ganghwa.setCapitalData("인천광역시");
        inchun_gyeyang.setCapitalData("인천광역시");
        inchun__junggu.setCapitalData("인천광역시");
        inchun_namdonggu.setCapitalData("인천광역시");
        inchun_namgu.setCapitalData("인천광역시");
        inchun_ongjin.setCapitalData("인천광역시");
        inchun_seogu.setCapitalData("인천광역시");
        inchun_yeonsu.setCapitalData("인천광역시");
        gangwon_all.setCapitalData("강원도");
        gangwon_cheorwon.setCapitalData("강원도");
        gangwon_chuncheon.setCapitalData("강원도");
        gangwon_donghae.setCapitalData("강원도");
        gangwon_gangneung.setCapitalData("강원도");
        gangwon_goseong.setCapitalData("강원도");
        gangwon_hoengseong.setCapitalData("강원도");
        gangwon_hongcheon.setCapitalData("강원도");
        gangwon_hwacheon.setCapitalData("강원도");
        gangwon_inje.setCapitalData("강원도");
        gangwon_jeongseon.setCapitalData("강원도");
        gangwon_pyeongchang.setCapitalData("강원도");
        gangwon_samcheok.setCapitalData("강원도");
        gangwon_sokcho.setCapitalData("강원도");
        gangwon_taebaek.setCapitalData("강원도");
        gangwon_wonju.setCapitalData("강원도");
        gangwon_yanggu.setCapitalData("강원도");
        gangwon_yangyang.setCapitalData("강원도");
        gangwon_yeongwol.setCapitalData("강원도");
        gwangju_all.setCapitalData("광주광역시");
        gwangju_bukgu.setCapitalData("광주광역시");
        gwangju_donggu.setCapitalData("광주광역시");
        gwangju_gwangsan.setCapitalData("광주광역시");
        gwangju_namgu.setCapitalData("광주광역시");
        gwangju_seogu.setCapitalData("광주광역시");
        chungnam_all.setCapitalData("충청남도");
        chungnam_asan.setCapitalData("충청남도");
        chungnam_boryeong.setCapitalData("충청남도");
        chungnam_buyeo.setCapitalData("충청남도");
        chungnam_cheonan.setCapitalData("충청남도");
        chungnam_cheongyang.setCapitalData("충청남도");
        chungnam_dangjin.setCapitalData("충청남도");
        chungnam_geumsan.setCapitalData("충청남도");
        chungnam_gongju.setCapitalData("충청남도");
        chungnam_gyeryong.setCapitalData("충청남도");
        chungnam_hongseong.setCapitalData("충청남도");
        chungnam_nonsan.setCapitalData("충청남도");
        chungnam_sejong.setCapitalData("충청남도");
        chungnam_seocheon.setCapitalData("충청남도");
        chungnam_seosan.setCapitalData("충청남도");
        chungnam_taean.setCapitalData("충청남도");
        chungnam_yesan.setCapitalData("충청남도");
        chungbuk_all.setCapitalData("충청북도");
        chungbuk_boeun.setCapitalData("충청북도");
        chungbuk_cheongju.setCapitalData("충청북도");
        chungbuk_chungju.setCapitalData("충청북도");
        chungbuk_danyang.setCapitalData("충청북도");
        chungbuk_eumseong.setCapitalData("충청북도");
        chungbuk_goesan.setCapitalData("충청북도");
        chungbuk_jecheon.setCapitalData("충청북도");
        chungbuk_jeungpyeong.setCapitalData("충청북도");
        chungbuk_jincheon.setCapitalData("충청북도");
        chungbuk_okcheon.setCapitalData("충청북도");
        chungbuk_yeongdong.setCapitalData("충청북도");
        daejeon_all.setCapitalData("대전광역시");
        daejeon_daedeok.setCapitalData("대전광역시");
        daejeon_donggu.setCapitalData("대전광역시");
        daejeon_junggu.setCapitalData("대전광역시");
        daejeon_seogu.setCapitalData("대전광역시");
        daejeon_yuseong.setCapitalData("대전광역시");
        gyungbuk_all.setCapitalData("경상북도");
        gyungbuk_andong.setCapitalData("경상북도");
        gyungbuk_bonghwa.setCapitalData("경상북도");
        gyungbuk_cheongdo.setCapitalData("경상북도");
        gyungbuk_cheongsong.setCapitalData("경상북도");
        gyungbuk_chilgok.setCapitalData("경상북도");
        gyungbuk_gimcheon.setCapitalData("경상북도");
        gyungbuk_goryeong.setCapitalData("경상북도");
        gyungbuk_gumi.setCapitalData("경상북도");
        gyungbuk_gunwi.setCapitalData("경상북도");
        gyungbuk_gyeongju.setCapitalData("경상북도");
        gyungbuk_gyeongsan.setCapitalData("경상북도");
        gyungbuk_mungyeong.setCapitalData("경상북도");
        gyungbuk_pohang.setCapitalData("경상북도");
        gyungbuk_sangju.setCapitalData("경상북도");
        gyungbuk_seongju.setCapitalData("경상북도");
        gyungbuk_uiseong.setCapitalData("경상북도");
        gyungbuk_uljin.setCapitalData("경상북도");
        gyungbuk_yecheon.setCapitalData("경상북도");
        gyungbuk_yeongcheon.setCapitalData("경상북도");
        gyungbuk_yeongdeok.setCapitalData("경상북도");
        gyungbuk_yeongju.setCapitalData("경상북도");
        gyungbuk_yeongyang.setCapitalData("경상북도");
        daegu_all.setCapitalData("대구광역시");
        daegu_bukgu.setCapitalData("대구광역시");
        daegu_dalseo.setCapitalData("대구광역시");
        daegu_dalseong.setCapitalData("대구광역시");
        daegu_dalseong1.setCapitalData("대구광역시");
        daegu_donggu.setCapitalData("대구광역시");
        daegu_junggu.setCapitalData("대구광역시");
        daegu_seogu.setCapitalData("대구광역시");
        daegu_suseong.setCapitalData("대구광역시");
        daegu_namgu.setCapitalData("대구광역시");
        ulsan_all.setCapitalData("울산광역시");
        ulsan_bukgu.setCapitalData("울산광역시");
        ulsan_donggu.setCapitalData("울산광역시");
        ulsan_junggu.setCapitalData("울산광역시");
        ulsan_namgu.setCapitalData("울산광역시");
        ulsan_ulju.setCapitalData("울산광역시");
        jeonbuk_all.setCapitalData("전라북도");
        jeonbuk_buan.setCapitalData("전라북도");
        jeonbuk_gimje.setCapitalData("전라북도");
        jeonbuk_gochang.setCapitalData("전라북도");
        jeonbuk_gunsan.setCapitalData("전라북도");
        jeonbuk_iksan.setCapitalData("전라북도");
        jeonbuk_imsil.setCapitalData("전라북도");
        jeonbuk_jangsu.setCapitalData("전라북도");
        jeonbuk_jeongeup.setCapitalData("전라북도");
        jeonbuk_jeonju.setCapitalData("전라북도");
        jeonbuk_jinan.setCapitalData("전라북도");
        jeonbuk_muju.setCapitalData("전라북도");
        jeonbuk_namwon.setCapitalData("전라북도");
        jeonbuk_sunchang.setCapitalData("전라북도");
        jeonbuk_finish.setCapitalData("전라북도");
        gyungnam_all.setCapitalData("경상남도");
        gyungnam_changnyeong.setCapitalData("경상남도");
        gyungnam_changwon.setCapitalData("경상남도");
        gyungnam_geochang.setCapitalData("경상남도");
        gyungnam_geoje.setCapitalData("경상남도");
        gyungnam_gimhae.setCapitalData("경상남도");
        gyungnam_goseong.setCapitalData("경상남도");
        gyungnam_hadong.setCapitalData("경상남도");
        gyungnam_haman.setCapitalData("경상남도");
        gyungnam_hamyang.setCapitalData("경상남도");
        gyungnam_hapcheon.setCapitalData("경상남도");
        gyungnam_jinju.setCapitalData("경상남도");
        gyungnam_miryang.setCapitalData("경상남도");
        gyungnam_namhae.setCapitalData("경상남도");
        gyungnam_sacheon.setCapitalData("경상남도");
        gyungnam_sancheong.setCapitalData("경상남도");
        gyungnam_tongyeong.setCapitalData("경상남도");
        gyungnam_uiryeong.setCapitalData("경상남도");
        gyungnam_yangsan.setCapitalData("경상남도");
        busan_all.setCapitalData("부산광역시");
        busan_bukgu.setCapitalData("부산광역시");
        busan_donggu.setCapitalData("부산광역시");
        busan_dongnae.setCapitalData("부산광역시");
        busan_gangseo.setCapitalData("부산광역시");
        busan_geumjeong.setCapitalData("부산광역시");
        busan_gijang.setCapitalData("부산광역시");
        busan_haeundae.setCapitalData("부산광역시");
        busan_jingu.setCapitalData("부산광역시");
        busan_junggu.setCapitalData("부산광역시");
        busan_namgu.setCapitalData("부산광역시");
        busan_saha.setCapitalData("부산광역시");
        busan_sasang.setCapitalData("부산광역시");
        busan_seogu.setCapitalData("부산광역시");
        busan_suyeong.setCapitalData("부산광역시");
        busan_yeongdo.setCapitalData("부산광역시");
        busan_yeonje.setCapitalData("부산광역시");
        jeonnam_all.setCapitalData("전라남도");
        jeonnam_boseong.setCapitalData("전라남도");
        jeonnam_damyang.setCapitalData("전라남도");
        jeonnam_gangjin.setCapitalData("전라남도");
        jeonnam_goheung.setCapitalData("전라남도");
        jeonnam_gokseong.setCapitalData("전라남도");
        jeonnam_gurye.setCapitalData("전라남도");
        jeonnam_gwangyang.setCapitalData("전라남도");
        jeonnam_haenam.setCapitalData("전라남도");
        jeonnam_hampyeong.setCapitalData("전라남도");
        jeonnam_hwasun.setCapitalData("전라남도");
        jeonnam_jangheung.setCapitalData("전라남도");
        jeonnam_jangseong.setCapitalData("전라남도");
        jeonnam_jindo.setCapitalData("전라남도");
        jeonnam_mokpo.setCapitalData("전라남도");
        jeonnam_muan.setCapitalData("전라남도");
        jeonnam_naju.setCapitalData("전라남도");
        jeonnam_sinan.setCapitalData("전라남도");
        jeonnam_suncheon.setCapitalData("전라남도");
        jeonnam_wando.setCapitalData("전라남도");
        jeonnam_yeongam.setCapitalData("전라남도");
        jeonnam_yeonggwang.setCapitalData("전라남도");
        jeonnam_yeosu.setCapitalData("전라남도");
        jeju_all.setCapitalData("제주특별자치도");
        jeju_jeju.setCapitalData("제주특별자치도");
        jeju_seogwipo.setCapitalData("제주특별자치도");

        seoul_all.setLocalData("전체");
        seoul_dobong.setLocalData("도봉구");
        seoul_dongdaemun.setLocalData("동대문구");
        seoul_dongjak.setLocalData("동작구");
        seoul_eunpyeong.setLocalData("은평구");
        seoul_gangbuk.setLocalData("강북구");
        seoul_gangdong.setLocalData("강동구");
        seoul_gangnam.setLocalData("강남구");
        seoul_gangseo.setLocalData("강서구");
        seoul_geumcheon.setLocalData("금천구");
        seoul_guro.setLocalData("구로구");
        seoul_gwanak.setLocalData("관악구");
        seoul_gwangjin.setLocalData("광진");
        seoul_jongno.setLocalData("종로구");
        seoul_junggu.setLocalData("중구");
        seoul_jungnang.setLocalData("중랑구");
        seoul_mapo.setLocalData("마포구");
        seoul_nowon.setLocalData("노원구");
        seoul_seocho.setLocalData("서초구");
        seoul_seodaemun.setLocalData("서대문");
        seoul_seongbuk.setLocalData("성북구");
        seoul_seongdong.setLocalData("성동구");
        seoul_songpa.setLocalData("송파구");
        seoul_yangchun.setLocalData("양천구");
        seoul_yeongdeungpo.setLocalData("영등포구");
        seoul_yongsan.setLocalData("용산");
        gyunggi_all.setLocalData("전체");
        gyunggi_ansan.setLocalData("안산");
        gyunggi_anseong.setLocalData("안성");
        gyunggi_anyang.setLocalData("안양");
        gyunggi_bucheon.setLocalData("부천");
        gyunggi_dongducheon.setLocalData("동두천");
        gyunggi_gapyeong.setLocalData("가평");
        gyunggi_gimpo.setLocalData("김포");
        gyunggi_goyang.setLocalData("고양");
        gyunggi_gunpo.setLocalData("군포");
        gyunggi_guri.setLocalData("구리");
        gyunggi_gwacheon.setLocalData("과천");
        gyunggi_gwangmyeong.setLocalData("광명");
        gyunggi_gwangju.setLocalData("광주");
        gyunggi_hanam.setLocalData("하남");
        gyunggi_hwaseong.setLocalData("화성");
        gyunggi_icheon.setLocalData("이천");
        gyunggi_namyangju.setLocalData("남양주");
        gyunggi_osan.setLocalData("오산");
        gyunggi_paju.setLocalData("파주");
        gyunggi_pocheon.setLocalData("포천");
        gyunggi_pyeongtaek.setLocalData("평택");
        gyunggi_seongnam.setLocalData("성남");
        gyunggi_siheung.setLocalData("시흥");
        gyunggi_suwon.setLocalData("수원");
        gyunggi_uijeongbu.setLocalData("의정부");
        gyunggi_uiwang.setLocalData("의왕");
        gyunggi_yangju.setLocalData("양주");
        gyunggi_yangpyeong.setLocalData("양평");
        gyunggi_yeoju.setLocalData("여주");
        gyunggi_yeoncheon.setLocalData("연천");
        gyunggi_yongin.setLocalData("용인");
        inchun_all.setLocalData("전체");
        inchun_bupyeong.setLocalData("부평구");
        inchun_donggu.setLocalData("동구");
        inchun_ganghwa.setLocalData("강화");
        inchun_gyeyang.setLocalData("계양구");
        inchun__junggu.setLocalData("중구");
        inchun_namdonggu.setLocalData("남동구");
        inchun_namgu.setLocalData("남구");
        inchun_ongjin.setLocalData("옹진");
        inchun_seogu.setLocalData("서구");
        inchun_yeonsu.setLocalData("연수구");
        gangwon_all.setLocalData("전체");
        gangwon_cheorwon.setLocalData("철원");
        gangwon_chuncheon.setLocalData("춘천");
        gangwon_donghae.setLocalData("동해");
        gangwon_gangneung.setLocalData("강릉");
        gangwon_goseong.setLocalData("고성");
        gangwon_hoengseong.setLocalData("횡성");
        gangwon_hongcheon.setLocalData("홍천");
        gangwon_hwacheon.setLocalData("화천");
        gangwon_inje.setLocalData("인제");
        gangwon_jeongseon.setLocalData("정선");
        gangwon_pyeongchang.setLocalData("평창");
        gangwon_samcheok.setLocalData("삼척");
        gangwon_sokcho.setLocalData("속초");
        gangwon_taebaek.setLocalData("태백");
        gangwon_wonju.setLocalData("원주");
        gangwon_yanggu.setLocalData("양구");
        gangwon_yangyang.setLocalData("양양");
        gangwon_yeongwol.setLocalData("영월");
        gwangju_all.setLocalData("전체");
        gwangju_bukgu.setLocalData("북구");
        gwangju_donggu.setLocalData("동구");
        gwangju_gwangsan.setLocalData("광산구");
        gwangju_namgu.setLocalData("남구");
        gwangju_seogu.setLocalData("서구");
        chungnam_all.setLocalData("전체");
        chungnam_asan.setLocalData("아산");
        chungnam_boryeong.setLocalData("보령");
        chungnam_buyeo.setLocalData("부여");
        chungnam_cheonan.setLocalData("천안");
        chungnam_cheongyang.setLocalData("청양");
        chungnam_dangjin.setLocalData("당진");
        chungnam_geumsan.setLocalData("금산");
        chungnam_gongju.setLocalData("공주");
        chungnam_gyeryong.setLocalData("계룡");
        chungnam_hongseong.setLocalData("홍성");
        chungnam_nonsan.setLocalData("논산");
        chungnam_sejong.setLocalData("세종시");
        chungnam_seocheon.setLocalData("서천");
        chungnam_seosan.setLocalData("서산");
        chungnam_taean.setLocalData("태안");
        chungnam_yesan.setLocalData("예산");
        chungbuk_all.setLocalData("전체");
        chungbuk_boeun.setLocalData("보은");
        chungbuk_cheongju.setLocalData("청주");
        chungbuk_chungju.setLocalData("충주");
        chungbuk_danyang.setLocalData("단양");
        chungbuk_eumseong.setLocalData("음성");
        chungbuk_goesan.setLocalData("괴산");
        chungbuk_jecheon.setLocalData("제천");
        chungbuk_jeungpyeong.setLocalData("증평");
        chungbuk_jincheon.setLocalData("진천");
        chungbuk_okcheon.setLocalData("옥천");
        chungbuk_yeongdong.setLocalData("영동");
        daejeon_all.setLocalData("전체");
        daejeon_daedeok.setLocalData("대덕구");
        daejeon_donggu.setLocalData("동구");
        daejeon_junggu.setLocalData("중구");
        daejeon_seogu.setLocalData("서구");
        daejeon_yuseong.setLocalData("유성구");
        gyungbuk_all.setLocalData("전체");
        gyungbuk_andong.setLocalData("안동");
        gyungbuk_bonghwa.setLocalData("봉화");
        gyungbuk_cheongdo.setLocalData("청도");
        gyungbuk_cheongsong.setLocalData("청송");
        gyungbuk_chilgok.setLocalData("칠곡");
        gyungbuk_gimcheon.setLocalData("김천");
        gyungbuk_goryeong.setLocalData("고령");
        gyungbuk_gumi.setLocalData("구미");
        gyungbuk_gunwi.setLocalData("군위");
        gyungbuk_gyeongju.setLocalData("경주");
        gyungbuk_gyeongsan.setLocalData("경산");
        gyungbuk_mungyeong.setLocalData("문경");
        gyungbuk_pohang.setLocalData("포항");
        gyungbuk_sangju.setLocalData("상주");
        gyungbuk_seongju.setLocalData("성주");
        gyungbuk_uiseong.setLocalData("의성");
        gyungbuk_uljin.setLocalData("울진");
        gyungbuk_yecheon.setLocalData("예천");
        gyungbuk_yeongcheon.setLocalData("영천");
        gyungbuk_yeongdeok.setLocalData("영덕");
        gyungbuk_yeongju.setLocalData("영주");
        gyungbuk_yeongyang.setLocalData("영양");
        daegu_all.setLocalData("전체");
        daegu_bukgu.setLocalData("북구");
        daegu_dalseo.setLocalData("달서구");
        daegu_dalseong.setLocalData("달성군");
        daegu_dalseong1.setLocalData("달성1");
        daegu_donggu.setLocalData("동구");
        daegu_junggu.setLocalData("중구");
        daegu_seogu.setLocalData("서구");
        daegu_suseong.setLocalData("수성구");
        daegu_namgu.setLocalData("남구");
        ulsan_all.setLocalData("전체");
        ulsan_bukgu.setLocalData("북구");
        ulsan_donggu.setLocalData("동구");
        ulsan_junggu.setLocalData("중구");
        ulsan_namgu.setLocalData("남구");
        ulsan_ulju.setLocalData("울주");
        jeonbuk_all.setLocalData("전체");
        jeonbuk_buan.setLocalData("부안");
        jeonbuk_gimje.setLocalData("김제");
        jeonbuk_gochang.setLocalData("고창");
        jeonbuk_gunsan.setLocalData("군산");
        jeonbuk_iksan.setLocalData("익산");
        jeonbuk_imsil.setLocalData("임실");
        jeonbuk_jangsu.setLocalData("장수");
        jeonbuk_jeongeup.setLocalData("정읍");
        jeonbuk_jeonju.setLocalData("전주");
        jeonbuk_jinan.setLocalData("진안");
        jeonbuk_muju.setLocalData("무주");
        jeonbuk_namwon.setLocalData("남원");
        jeonbuk_sunchang.setLocalData("순창");
        jeonbuk_finish.setLocalData("완주");
        gyungnam_all.setLocalData("전체");
        gyungnam_changnyeong.setLocalData("창녕");
        gyungnam_changwon.setLocalData("창원");
        gyungnam_geochang.setLocalData("거창");
        gyungnam_geoje.setLocalData("거제");
        gyungnam_gimhae.setLocalData("김해");
        gyungnam_goseong.setLocalData("고성");
        gyungnam_hadong.setLocalData("하동");
        gyungnam_haman.setLocalData("함안");
        gyungnam_hamyang.setLocalData("함양");
        gyungnam_hapcheon.setLocalData("합천");
        gyungnam_jinju.setLocalData("진주");
        gyungnam_miryang.setLocalData("밀양");
        gyungnam_namhae.setLocalData("남해");
        gyungnam_sacheon.setLocalData("사천");
        gyungnam_sancheong.setLocalData("산청");
        gyungnam_tongyeong.setLocalData("통영");
        gyungnam_uiryeong.setLocalData("의령");
        gyungnam_yangsan.setLocalData("양산");
        busan_all.setLocalData("전체");
        busan_bukgu.setLocalData("북구");
        busan_donggu.setLocalData("동구");
        busan_dongnae.setLocalData("동래구");
        busan_gangseo.setLocalData("강서구");
        busan_geumjeong.setLocalData("금정구");
        busan_gijang.setLocalData("기장군");
        busan_haeundae.setLocalData("해운대구");
        busan_jingu.setLocalData("진구");
        busan_junggu.setLocalData("중구");
        busan_namgu.setLocalData("남구");
        busan_saha.setLocalData("사하구");
        busan_sasang.setLocalData("사상구");
        busan_seogu.setLocalData("서구");
        busan_suyeong.setLocalData("수영구");
        busan_yeongdo.setLocalData("영도");
        busan_yeonje.setLocalData("연제");
        jeonnam_all.setLocalData("전체");
        jeonnam_boseong.setLocalData("보성");
        jeonnam_damyang.setLocalData("담양");
        jeonnam_gangjin.setLocalData("강진");
        jeonnam_goheung.setLocalData("고흥");
        jeonnam_gokseong.setLocalData("곡성");
        jeonnam_gurye.setLocalData("구례");
        jeonnam_gwangyang.setLocalData("광양");
        jeonnam_haenam.setLocalData("해남");
        jeonnam_hampyeong.setLocalData("함평");
        jeonnam_hwasun.setLocalData("화순");
        jeonnam_jangheung.setLocalData("장흥");
        jeonnam_jangseong.setLocalData("장성");
        jeonnam_jindo.setLocalData("진도");
        jeonnam_mokpo.setLocalData("목포");
        jeonnam_muan.setLocalData("무안");
        jeonnam_naju.setLocalData("나주");
        jeonnam_sinan.setLocalData("신안");
        jeonnam_suncheon.setLocalData("순천");
        jeonnam_wando.setLocalData("완도");
        jeonnam_yeongam.setLocalData("영암");
        jeonnam_yeonggwang.setLocalData("영광");
        jeonnam_yeosu.setLocalData("여수");
        jeju_all.setLocalData("전체");
        jeju_jeju.setLocalData("제주시");
        jeju_seogwipo.setLocalData("서귀포시");


    }
}
