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

    // الأقسام الرئيسية
    private static final int MAIN_MENU = 0;
    private static final int NAVIGATION = 1;
    private static final int CHARACTER = 2;
    private static final int VEHICLES = 3;
    private static final int FINANCE = 4;
    private static final int JOBS = 5;
    private static final int PROPERTIES = 6;
    private static final int LICENSES = 7;
    private static final int INVENTORY = 8;
    private static final int MISSIONS = 9;
    private static final int POLICE = 10;
    private static final int SERVICES = 11;
    private static final int SETTINGS = 12;
    private static final int GUIDE = 13;

    // الملاحة
    private static final int GOVERNMENT = 20;
    private static final int ILLEGAL = 21;
    private static final int LOCATIONS = 22;

    // المنظمات غير الشرعية
    private static final int GANGS = 30;
    private static final int MAFIA = 31;
    private static final int SECRET_ORGS = 32;
    private static final int GANG_WAREHOUSES = 33;
    private static final int WAR_ZONES = 34;

    @SuppressLint("InflateParams")
    public Menu(Activity aactivity) {

        activity = aactivity;

        anim = AnimationUtils.loadAnimation(
                aactivity,
                R.anim.button_click
        );

        menu_layout =
                aactivity.findViewById(
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

    public void ShowMenu() {
        showMainMenu();
        Utils.ShowLayout(menu_layout, true);
    }

    // =========================
    // القائمة الرئيسية
    // =========================

    private void showMainMenu() {

        menuTitle = activity.findViewById(
                R.id.br_menu_title
        );

        menuTitle.setText("NAVARA ROLEPLAY");

        setMainMenu();

        showRecycler(
                4,
                dataDialogMenuArrayList,
                this::mainMenuClick
        );
    }

    private void setMainMenu() {

        dataDialogMenuArrayList.clear();

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        NAVIGATION,
                        R.drawable.br_menu_compass,
                        "🗺️ الملاحة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        CHARACTER,
                        R.drawable.br_menu_menu,
                        "👤 الشخصية"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        VEHICLES,
                        R.drawable.br_menu_car,
                        "🚗 المركبات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        FINANCE,
                        R.drawable.br_menu_ruble,
                        "💰 البنك والمالية"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        JOBS,
                        R.drawable.br_menu_menu,
                        "💼 الوظائف"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        PROPERTIES,
                        R.drawable.br_menu_menu,
                        "🏠 العقارات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        LICENSES,
                        R.drawable.br_menu_paper,
                        "🪪 الرخص"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        INVENTORY,
                        R.drawable.br_menu_bag,
                        "🎒 الحقيبة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        MISSIONS,
                        R.drawable.br_menu_menu,
                        "🎯 المهام"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        POLICE,
                        R.drawable.br_menu_menu,
                        "👮 الشرطة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        SERVICES,
                        R.drawable.br_menu_menu,
                        "🛠️ الخدمات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        SETTINGS,
                        R.drawable.br_menu_menu,
                        "⚙️ الإعدادات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        GUIDE,
                        R.drawable.br_menu_menu,
                        "📖 دليل NAVARA"
                )
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

    // =========================
    // الملاحة
    // =========================

    private void showNavigation() {

        menuTitle.setText("🗺️ الملاحة");

        dataDialogMenuArrayList.clear();

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        GOVERNMENT,
                        R.drawable.br_menu_menu,
                        "🏛️ المنظمات الحكومية"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        ILLEGAL,
                        R.drawable.br_menu_menu,
                        "🔫 المنظمات غير الشرعية"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        LOCATIONS,
                        R.drawable.br_menu_compass,
                        "📍 الأماكن والمواقع"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        MAIN_MENU,
                        R.drawable.menu_back,
                        "↩️ رجوع"
                )
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

                case LOCATIONS:
                    showLocations();
                    break;

                case MAIN_MENU:
                    showMainMenu();
                    break;
            }

        }, 200);
    }

    // =========================
    // المنظمات الحكومية
    // =========================

    private void showGovernmentOrganizations() {

        menuTitle.setText("🏛️ المنظمات الحكومية");

        dataDialogMenuArrayList.clear();

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        100,
                        R.drawable.br_menu_menu,
                        "👮 الشرطة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        101,
                        R.drawable.br_menu_menu,
                        "🚑 الإسعاف"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        102,
                        R.drawable.br_menu_menu,
                        "🚒 الإطفاء"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        103,
                        R.drawable.br_menu_menu,
                        "🔧 الميكانيكي"
        ));

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        104,
                        R.drawable.br_menu_menu,
                        "🚕 التاكسي"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        105,
                        R.drawable.br_menu_menu,
                        "⚖️ المحكمة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        106,
                        R.drawable.br_menu_menu,
                        "🏛️ الحكومة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        NAVIGATION,
                        R.drawable.menu_back,
                        "↩️ رجوع"
                )
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) ->
                        handleNavigationLocation(item.getId())
        );
    }

    // =========================
    // المنظمات غير الشرعية
    // =========================

    private void showIllegalOrganizations() {

        menuTitle.setText("🔫 المنظمات غير الشرعية");

        dataDialogMenuArrayList.clear();

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        GANGS,
                        R.drawable.br_menu_menu,
                        "🏴 العصابات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        MAFIA,
                        R.drawable.br_menu_menu,
                        "💀 المافيا"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        SECRET_ORGS,
                        R.drawable.br_menu_menu,
                        "🕶️ المنظمات السرية"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        GANG_WAREHOUSES,
                        R.drawable.br_menu_menu,
                        "📦 مخازن العصابات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        WAR_ZONES,
                        R.drawable.br_menu_menu,
                        "🔥 مناطق الحروب"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        NAVIGATION,
                        R.drawable.menu_back,
                        "↩️ رجوع"
                )
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
                        handleNavigationLocation(item.getId());
                    }

                }
        );
    }

    // =========================
    // العصابات
    // =========================

    private void showGangs() {

        menuTitle.setText("🏴 العصابات");

        dataDialogMenuArrayList.clear();

        // العصابات الموجودة بالسيرفر
        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        200,
                        R.drawable.br_menu_menu,
                        "🟡 Vagos"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        201,
                        R.drawable.br_menu_menu,
                        "🟣 Ballas"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        202,
                        R.drawable.br_menu_menu,
                        "🟢 Families"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        203,
                        R.drawable.br_menu_menu,
                        "🔵 Aztecas"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        204,
                        R.drawable.br_menu_menu,
                        "🟢 Grove Street"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        ILLEGAL,
                        R.drawable.menu_back,
                        "↩️ رجوع"
                )
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == ILLEGAL) {
                        showIllegalOrganizations();
                    } else {
                        showGangBase(item.getId());
                    }

                }
        );
    }

    // =========================
    // مقر العصابة
    // =========================

    private void showGangBase(int gangId) {

        String gangName;

        switch (gangId) {

            case 200:
                gangName = "Vagos";
                break;

            case 201:
                gangName = "Ballas";
                break;

            case 202:
                gangName = "Families";
                break;

            case 203:
                gangName = "Aztecas";
                break;

            case 204:
                gangName = "Grove Street";
                break;

            default:
                gangName = "العصابة";
                break;
        }

        menuTitle.setText("🏴 " + gangName);

        dataDialogMenuArrayList.clear();

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        300 + gangId,
                        R.drawable.br_menu_compass,
                        "📍 تحديد مقر العصابة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        400 + gangId,
                        R.drawable.br_menu_menu,
                        "📋 معلومات العصابة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        GANGS,
                        R.drawable.menu_back,
                        "↩️ رجوع"
                )
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == GANGS) {
                        showGangs();
                    } else {
                        handleNavigationLocation(item.getId());
                    }

                }
        );
    }

    // =========================
    // الأماكن
    // =========================

    private void showLocations() {

        menuTitle.setText("📍 الأماكن والمواقع");

        dataDialogMenuArrayList.clear();

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        500,
                        R.drawable.br_menu_menu,
                        "🏦 البنوك"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        501,
                        R.drawable.br_menu_menu,
                        "🏪 المتاجر"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        502,
                        R.drawable.br_menu_menu,
                        "🏥 المستشفيات"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        503,
                        R.drawable.br_menu_menu,
                        "⛽ محطات الوقود"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        504,
                        R.drawable.br_menu_menu,
                        "👕 محلات الملابس"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        505,
                        R.drawable.br_menu_menu,
                        "🔫 متاجر الأسلحة"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        506,
                        R.drawable.br_menu_menu,
                        "🎰 الكازينو"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        507,
                        R.drawable.br_menu_menu,
                        "✈️ المطار"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        508,
                        R.drawable.br_menu_menu,
                        "🚢 الميناء"
                )
        );

        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        NAVIGATION,
                        R.drawable.menu_back,
                        "↩️ رجوع"
                )
        );

        showRecycler(
                2,
                dataDialogMenuArrayList,
                (item, view) -> {

                    if (item.getId() == NAVIGATION) {
                        showNavigation();
                    } else {
                        handleNavigationLocation(item.getId());
                    }

                }
        );
    }

    // =========================
    // إرسال أمر للسيرفر
    // =========================

    private void handleNavigationLocation(int id) {
        sendServerAction(id);
    }

    private void sendServerAction(int id) {

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

    // =========================
    // RecyclerView
    // =========================

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

        recyclerView.setAdapter(adapter);
    }

    // =========================
    // إغلاق القائمة
    // =========================

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
