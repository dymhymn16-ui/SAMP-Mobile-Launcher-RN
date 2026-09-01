package com.touch.mobile.dark.gui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nvidia.devtech.NvEventQueueActivity;
import com.touch.mobile.dark.R;
import com.touch.mobile.dark.gui.adapters.DialogMenuAdapter;
import com.touch.mobile.dark.gui.models.DataDialogMenu;
import com.touch.mobile.dark.gui.util.Utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Menu {

    public View mRootView;
    public Activity activity;
    public LinearLayout menu_layout;
    public TextView menuTitle;

    private final Animation anim;
    private int index = -1;

    private final ArrayList<DataDialogMenu> dataDialogMenuArrayList =
            new ArrayList<>();

    // =========================================================
    // الأقسام الرئيسية
    // =========================================================

    private static final int MAIN_MENU = 0;

    private static final int CHARACTER = 1;
    private static final int NAVIGATION = 2;
    private static final int VEHICLES = 3;
    private static final int FINANCE = 4;
    private static final int JOBS = 5;
    private static final int PROPERTIES = 6;
    private static final int LICENSES = 7;
    private static final int INVENTORY = 8;
    private static final int MISSIONS = 9;
    private static final int CAPTURE = 10;
    private static final int COMMANDS = 11;
    private static final int SETTINGS = 12;
    private static final int GUIDE = 13;

    // =========================================================
    // الملاحة
    // =========================================================

    private static final int GOVERNMENT = 20;
    private static final int ILLEGAL = 21;
    private static final int DEALERSHIPS = 22;
    private static final int BIKE_DEALERSHIPS = 23;
    private static final int LOCATIONS = 24;

    // =========================================================
    // المنظمات الحكومية
    // =========================================================

    private static final int POLICE = 100;
    private static final int AMBULANCE = 101;
    private static final int FIRE_DEPARTMENT = 102;
    private static final int MECHANIC = 103;
    private static final int TAXI = 104;
    private static final int COURT = 105;
    private static final int GOVERNMENT_ORG = 106;
    private static final int ARMY = 107;

    // =========================================================
    // المنظمات غير الشرعية
    // =========================================================

    private static final int GANGS = 200;
    private static final int MAFIA = 201;
    private static final int SECRET_ORGS = 202;
    private static final int GANG_WAREHOUSES = 203;
    private static final int WAR_ZONES = 204;

    // =========================================================
    // العصابات
    // =========================================================

    private static final int VAGOS = 300;
    private static final int BALLAS = 301;
    private static final int FAMILIES = 302;
    private static final int AZTECAS = 303;
    private static final int GROVE = 304;

    // =========================================================
    // الأماكن
    // =========================================================

    private static final int BANKS = 500;
    private static final int STORES = 501;
    private static final int HOSPITALS = 502;
    private static final int GAS_STATIONS = 503;
    private static final int CLOTHING = 504;
    private static final int WEAPON_SHOPS = 505;
    private static final int CASINO = 506;
    private static final int AIRPORT = 507;
    private static final int PORT = 508;
    private static final int POLICE_STATION = 509;
    private static final int MECHANIC_SHOPS = 510;
    private static final int RESTAURANTS = 511;
    private static final int BARBERS = 512;
    private static final int ATM = 513;

    // =========================================================
    // معارض السيارات
    // =========================================================

    private static final int CAR_DEALER_1 = 600;
    private static final int CAR_DEALER_2 = 601;
    private static final int CAR_DEALER_3 = 602;
    private static final int CAR_DEALER_4 = 603;
    private static final int CAR_DEALER_5 = 604;

    // =========================================================
    // معارض الدراجات
    // =========================================================

    private static final int BIKE_DEALER_1 = 650;
    private static final int BIKE_DEALER_2 = 651;
    private static final int BIKE_DEALER_3 = 652;

    // =========================================================
    // القائمة
    // =========================================================

    @SuppressLint("InflateParams")
    public Menu(Activity aactivity) {

        activity = aactivity;

        anim = AnimationUtils.loadAnimation(
                aactivity,
                R.anim.button_click
        );

        menu_layout = aactivity.findViewById(
                R.id.main_menu_layout_new_layout
        );

        aactivity.findViewById(
                R.id.br_menu_close_new
        ).setOnClickListener(view -> close());

        this.mRootView =
                ((LayoutInflater)
                        aactivity.getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE
                        ))
                        .inflate(
                                R.layout.menu_dialog_layout,
                                null,
                                false
                        );

        Utils.HideLayout(menu_layout, false);
    }

    // =========================================================
    // فتح القائمة
    // =========================================================

    public void ShowMenu() {

        showMainMenu();

        Utils.ShowLayout(
                menu_layout,
                true
        );
    }

    // =========================================================
    // القائمة الرئيسية
    // =========================================================

    private void showMainMenu() {

        menuTitle = activity.findViewById(
                R.id.br_menu_title
        );

        menuTitle.setText(
                "☰ NAVARA ROLEPLAY"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                CHARACTER,
                R.drawable.br_menu_menu,
                "👤 الشخصية"
        );

        addItem(
                NAVIGATION,
                R.drawable.br_menu_compass,
                "🗺️ الملاحة"
        );

        addItem(
                VEHICLES,
                R.drawable.br_menu_car,
                "🚗 المركبات"
        );

        addItem(
                FINANCE,
                R.drawable.br_menu_ruble,
                "💰 البنك والمالية"
        );

        addItem(
                JOBS,
                R.drawable.br_menu_menu,
                "💼 الوظائف"
        );

        addItem(
                PROPERTIES,
                R.drawable.br_menu_menu,
                "🏠 العقارات"
        );

        addItem(
                LICENSES,
                R.drawable.br_menu_paper,
                "🪪 الرخص"
        );

        addItem(
                INVENTORY,
                R.drawable.br_menu_bag,
                "🎒 الحقيبة"
        );

        addItem(
                MISSIONS,
                R.drawable.br_menu_menu,
                "🎯 المهام"
        );

        // Capture
        addItem(
                CAPTURE,
                R.drawable.br_menu_menu,
                "⚔️ Capture"
        );

        addItem(
                COMMANDS,
                R.drawable.br_menu_menu,
                "📋 الأوامر"
        );

        addItem(
                SETTINGS,
                R.drawable.br_menu_menu,
                "⚙️ الإعدادات"
        );

        addItem(
                GUIDE,
                R.drawable.br_menu_menu,
                "📖 دليل NAVARA"
        );

        showRecycler(
                4,
                dataDialogMenuArrayList,
                this::mainMenuClick
        );
    }

    private void mainMenuClick(
            DataDialogMenu item,
            View view
    ) {

        index = item.getId();

        view.startAnimation(anim);

        new Handler().postDelayed(() -> {

            switch (index) {

                case NAVIGATION:
                    showNavigation();
                    break;

                default:
                    sendServerAction(index);
                    break;
            }

        }, 200);
    }

    // =========================================================
    // الملاحة
    // =========================================================

    private void showNavigation() {

        menuTitle.setText(
                "🗺️ الملاحة"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                GOVERNMENT,
                R.drawable.br_menu_menu,
                "🏛️ المنظمات الحكومية"
        );

        addItem(
                ILLEGAL,
                R.drawable.br_menu_menu,
                "🔫 المنظمات غير الشرعية"
        );

        addItem(
                DEALERSHIPS,
                R.drawable.br_menu_car,
                "🚗 معارض السيارات"
        );

        addItem(
                BIKE_DEALERSHIPS,
                R.drawable.br_menu_car,
                "🏍️ معارض الدراجات"
        );

        addItem(
                LOCATIONS,
                R.drawable.br_menu_compass,
                "📍 الأماكن والمواقع"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                this::navigationClick
        );
    }

    private void navigationClick(
            DataDialogMenu item,
            View view
    ) {

        index = item.getId();

        view.startAnimation(anim);

        new Handler().postDelayed(() -> {

            switch (index) {

                case GOVERNMENT:
                    showGovernmentOrganizations();
                    break;

                case ILLEGAL:
                    showIllegalOrganizations();
                    break;

                case DEALERSHIPS:
                    showCarDealerships();
                    break;

                case BIKE_DEALERSHIPS:
                    showBikeDealerships();
                    break;

                case LOCATIONS:
                    showLocations();
                    break;

                case MAIN_MENU:
                    showMainMenu();
                    break;
            }

        }, 200);
    }

    // =========================================================
    // المنظمات الحكومية
    // =========================================================

    private void showGovernmentOrganizations() {

        menuTitle.setText(
                "🏛️ المنظمات الحكومية"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                POLICE,
                R.drawable.br_menu_menu,
                "👮 الشرطة"
        );

        addItem(
                AMBULANCE,
                R.drawable.br_menu_menu,
                "🚑 الإسعاف"
        );

        addItem(
                FIRE_DEPARTMENT,
                R.drawable.br_menu_menu,
                "🚒 الإطفاء"
        );

        addItem(
                MECHANIC,
                R.drawable.br_menu_menu,
                "🔧 الميكانيكي"
        );

        addItem(
                TAXI,
                R.drawable.br_menu_menu,
                "🚕 التاكسي"
        );

        addItem(
                COURT,
                R.drawable.br_menu_menu,
                "⚖️ المحكمة"
        );

        addItem(
                GOVERNMENT_ORG,
                R.drawable.br_menu_menu,
                "🏛️ الحكومة"
        );

        addItem(
                ARMY,
                R.drawable.br_menu_menu,
                "🪖 الجيش"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == NAVIGATION) {
                        showNavigation();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // المنظمات غير الشرعية
    // =========================================================

    private void showIllegalOrganizations() {

        menuTitle.setText(
                "🔫 المنظمات غير الشرعية"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                GANGS,
                R.drawable.br_menu_menu,
                "🏴 العصابات"
        );

        addItem(
                MAFIA,
                R.drawable.br_menu_menu,
                "💀 المافيا"
        );

        addItem(
                SECRET_ORGS,
                R.drawable.br_menu_menu,
                "🕶️ المنظمات السرية"
        );

        addItem(
                GANG_WAREHOUSES,
                R.drawable.br_menu_menu,
                "📦 مخازن العصابات"
        );

        addItem(
                WAR_ZONES,
                R.drawable.br_menu_menu,
                "🔥 مناطق الحروب"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == GANGS) {

                        showGangs();

                    } else if (item.getId() == NAVIGATION) {

                        showNavigation();

                    } else {

                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // العصابات
    // =========================================================

    private void showGangs() {

        menuTitle.setText(
                "🏴 العصابات"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                VAGOS,
                R.drawable.br_menu_menu,
                "🟡 Vagos"
        );

        addItem(
                BALLAS,
                R.drawable.br_menu_menu,
                "🟣 Ballas"
        );

        addItem(
                FAMILIES,
                R.drawable.br_menu_menu,
                "🟢 Families"
        );

        addItem(
                AZTECAS,
                R.drawable.br_menu_menu,
                "🔵 Aztecas"
        );

        addItem(
                GROVE,
                R.drawable.br_menu_menu,
                "🟢 Grove Street"
        );

        addItem(
                ILLEGAL,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == ILLEGAL) {

                        showIllegalOrganizations();

                    } else {

                        showGangBase(
                                item.getId()
                        );
                    }

                }
        );
    }

    // =========================================================
    // مقر العصابة
    // =========================================================

    private void showGangBase(
            int gangId
    ) {

        String gangName;

        switch (gangId) {

            case VAGOS:
                gangName = "Vagos";
                break;

            case BALLAS:
                gangName = "Ballas";
                break;

            case FAMILIES:
                gangName = "Families";
                break;

            case AZTECAS:
                gangName = "Aztecas";
                break;

            case GROVE:
                gangName = "Grove Street";
                break;

            default:
                gangName = "العصابة";
                break;
        }

        menuTitle.setText(
                "🏴 " + gangName
        );

        dataDialogMenuArrayList.clear();

        addItem(
                700 + gangId,
                R.drawable.br_menu_compass,
                "📍 تحديد مقر العصابة"
        );

        addItem(
                800 + gangId,
                R.drawable.br_menu_menu,
                "📋 معلومات العصابة"
        );

        addItem(
                900 + gangId,
                R.drawable.br_menu_car,
                "🚗 مركبات العصابة"
        );

        addItem(
                1000 + gangId,
                R.drawable.br_menu_bag,
                "📦 مخزن العصابة"
        );

        addItem(
                GANGS,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == GANGS) {

                        showGangs();

                    } else {

                        sendServerAction(
                                item.getId()
                        );
                    }

                }
        );
    }

    // =========================================================
    // الأماكن والمواقع
    // =========================================================

    private void showLocations() {

        menuTitle.setText(
                "📍 الأماكن والمواقع"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                BANKS,
                R.drawable.br_menu_menu,
                "🏦 البنوك"
        );

        addItem(
                STORES,
                R.drawable.br_menu_menu,
                "🏪 المتاجر"
        );

        addItem(
                HOSPITALS,
                R.drawable.br_menu_menu,
                "🏥 المستشفيات"
        );

        addItem(
                GAS_STATIONS,
                R.drawable.br_menu_menu,
                "⛽ محطات الوقود"
        );

        addItem(
                CLOTHING,
                R.drawable.br_menu_menu,
                "👕 محلات الملابس"
        );

        addItem(
                WEAPON_SHOPS,
                R.drawable.br_menu_menu,
                "🔫 متاجر الأسلحة"
        );

        addItem(
                CASINO,
                R.drawable.br_menu_menu,
                "🎰 الكازينو"
        );

        addItem(
                AIRPORT,
                R.drawable.br_menu_menu,
                "✈️ المطار"
        );

        addItem(
                PORT,
                R.drawable.br_menu_menu,
                "🚢 الميناء"
        );

        addItem(
                POLICE_STATION,
                R.drawable.br_menu_menu,
                "👮 مراكز الشرطة"
        );

        addItem(
                MECHANIC_SHOPS,
                R.drawable.br_menu_menu,
                "🔧 ورش الميكانيكي"
        );

        addItem(
                RESTAURANTS,
                R.drawable.br_menu_menu,
                "🍔 المطاعم"
        );

        addItem(
                BARBERS,
                R.drawable.br_menu_menu,
                "💈 الحلاق"
        );

        addItem(
                ATM,
                R.drawable.br_menu_menu,
                "💳 أجهزة الصراف"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == NAVIGATION) {

                        showNavigation();

                    } else {

                        sendServerAction(
                                item.getId()
                        );
                    }

                }
        );
    }

    // =========================================================
    // معارض السيارات
    // =========================================================

    private void showCarDealerships() {

        menuTitle.setText(
                "🚗 معارض السيارات"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                CAR_DEALER_1,
                R.drawable.br_menu_car,
                "🚗 المعرض الرئيسي"
        );

        addItem(
                CAR_DEALER_2,
                R.drawable.br_menu_car,
                "🏎️ معرض السيارات الرياضية"
        );

        addItem(
                CAR_DEALER_3,
                R.drawable.br_menu_car,
                "🚙 معرض السيارات الفاخرة"
        );

        addItem(
                CAR_DEALER_4,
                R.drawable.br_menu_car,
                "🚘 معرض السيارات العائلية"
        );

        addItem(
                CAR_DEALER_5,
                R.drawable.br_menu_car,
                "🚐 معرض المركبات التجارية"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == NAVIGATION) {

                        showNavigation();

                    } else {

                        sendServerAction(
                                item.getId()
                        );
                    }

                }
        );
    }

    // =========================================================
    // معارض الدراجات
    // =========================================================

    private void showBikeDealerships() {

        menuTitle.setText(
                "🏍️ معارض الدراجات"
        );

        dataDialogMenuArrayList.clear();

        addItem(
                BIKE_DEALER_1,
                R.drawable.br_menu_car,
                "🏍️ معرض الدراجات الرئيسي"
        );

        addItem(
                BIKE_DEALER_2,
                R.drawable.br_menu_car,
                "🏁 معرض الدراجات الرياضية"
        );

        addItem(
                BIKE_DEALER_3,
                R.drawable.br_menu_car,
                "🛵 معرض الدراجات المدنية"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == NAVIGATION) {

                        showNavigation();

                    } else {

                        sendServerAction(
                                item.getId()
                        );
                    }

                }
        );
    }

    // =========================================================
    // إضافة عنصر للقائمة
    // =========================================================

    private void addItem(
            int id,
            int icon,
            String title
    ) {

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        id,
                        icon,
                        title
                )
        );
    }

    // =========================================================
    // إرسال الأمر للسيرفر
    // =========================================================

    private void sendServerAction(
            int id
    ) {

        try {

            NvEventQueueActivity.getInstance().sendRPC(
                    1,
                    String.valueOf(id)
                            .getBytes("windows-1251"),
                    id
            );

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
    }

    // =========================================================
    // RecyclerView
    // =========================================================

    private void showRecycler(
            int columns,
            ArrayList<DataDialogMenu> arrayList,
            DialogMenuAdapter.OnUserClickListener listener
    ) {

        RecyclerView recyclerView =
                activity.findViewById(
                        R.id.br_rec_view_menu
                );

        DialogMenuAdapter adapter =
                new DialogMenuAdapter(
                        arrayList,
                        listener
                );

        recyclerView.setLayoutManager(
                new GridLayoutManager(
                        mRootView.getContext(),
                        columns
                ) {

                    @Override
                    public boolean checkLayoutParams(
                            RecyclerView.LayoutParams params
                    ) {

                        float margin =
                                30.0f /
                                        mRootView
                                                .getResources()
                                                .getDisplayMetrics()
                                                .density;

                        int marginInt =
                                (int) margin;

                        params.setMarginStart(
                                marginInt
                        );

                        params.setMarginEnd(
                                marginInt
                        );

                        params.setMargins(
                                0,
                                marginInt,
                                0,
                                0
                        );

                        params.width =
                                (int)
                                        (
                                                ((float)
                                                        getWidth()
                                                                /
                                                        getSpanCount())
                                                        - margin
                                        );

                        return true;
                    }
                }
        );

        recyclerView.setAdapter(
                adapter
        );
    }

    // =========================================================
    // إغلاق القائمة
    // =========================================================

    public void close() {

        Utils.HideLayout(
                menu_layout,
                true
        );

        NvEventQueueActivity
                .getInstance()
                .togglePlayer(0);
    }
}
