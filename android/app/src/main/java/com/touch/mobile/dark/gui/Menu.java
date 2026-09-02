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
    // الشخصية
    // =========================================================

    private static final int CHARACTER_INFO = 1000;
    private static final int CHARACTER_STATS = 1001;
    private static final int CHARACTER_SKILLS = 1002;
    private static final int CHARACTER_ACHIEVEMENTS = 1003;
    private static final int CHARACTER_WARNINGS = 1004;
    private static final int CHARACTER_APPEARANCE = 1005;
    private static final int CHARACTER_STATUS = 1006;

    // =========================================================
    // المركبات
    // =========================================================

    private static final int MY_VEHICLES = 1100;
    private static final int VEHICLE_SPAWN = 1101;
    private static final int VEHICLE_PARK = 1102;
    private static final int VEHICLE_LOCK = 1103;
    private static final int VEHICLE_ENGINE = 1104;
    private static final int VEHICLE_INFO = 1105;

    // =========================================================
    // البنك
    // =========================================================

    private static final int BANK_BALANCE = 1200;
    private static final int BANK_DEPOSIT = 1201;
    private static final int BANK_WITHDRAW = 1202;
    private static final int BANK_TRANSFER = 1203;
    private static final int BANK_TRANSACTIONS = 1204;

    // =========================================================
    // الوظائف
    // =========================================================

    private static final int JOB_INFO = 1300;
    private static final int JOB_START = 1301;
    private static final int JOB_STOP = 1302;
    private static final int JOB_SKILL = 1303;
    private static final int JOB_SALARY = 1304;

    // =========================================================
    // العقارات
    // =========================================================

    private static final int MY_PROPERTIES = 1400;
    private static final int PROPERTY_INFO = 1401;
    private static final int PROPERTY_ENTER = 1402;
    private static final int PROPERTY_STORAGE = 1403;

    // =========================================================
    // الرخص
    // =========================================================

    private static final int LICENSE_CAR = 1500;
    private static final int LICENSE_BIKE = 1501;
    private static final int LICENSE_WEAPON = 1502;
    private static final int LICENSE_TRUCK = 1503;
    private static final int LICENSE_AIRCRAFT = 1504;
    private static final int LICENSE_BOAT = 1505;

    // =========================================================
    // الحقيبة
    // =========================================================

    private static final int INVENTORY_ITEMS = 1600;
    private static final int INVENTORY_WEAPONS = 1601;
    private static final int INVENTORY_KEYS = 1602;
    private static final int INVENTORY_DOCUMENTS = 1603;
    private static final int INVENTORY_MATERIALS = 1604;

    // =========================================================
    // المهام
    // =========================================================

    private static final int DAILY_MISSIONS = 1700;
    private static final int JOB_MISSIONS = 1701;
    private static final int GANG_MISSIONS = 1702;
    private static final int POLICE_MISSIONS = 1703;
    private static final int MISSION_REWARDS = 1704;

    // =========================================================
    // الإعدادات
    // =========================================================

    private static final int SETTINGS_CHAT = 1800;
    private static final int SETTINGS_CONTROLS = 1801;
    private static final int SETTINGS_GRAPHICS = 1802;
    private static final int SETTINGS_SOUND = 1803;
    private static final int SETTINGS_INTERFACE = 1804;

    // =========================================================
    // الإنشاء
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

        mRootView =
                ((LayoutInflater)
                        aactivity.getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE
                        ))
                        .inflate(
                                R.layout.menu_dialog_layout,
                                null,
                                false
                        );

        Utils.HideLayout(
                menu_layout,
                false
        );
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

        int id = item.getId();

        view.startAnimation(anim);

        new Handler().postDelayed(() -> {

            switch (id) {

                case CHARACTER:
                    showCharacter();
                    break;

                case NAVIGATION:
                    showNavigation();
                    break;

                case VEHICLES:
                    showVehicles();
                    break;

                case FINANCE:
                    showFinance();
                    break;

                case JOBS:
                    showJobs();
                    break;

                case PROPERTIES:
                    showProperties();
                    break;

                case LICENSES:
                    showLicenses();
                    break;

                case INVENTORY:
                    showInventory();
                    break;

                case MISSIONS:
                    showMissions();
                    break;

                case CAPTURE:
                    sendServerAction(CAPTURE);
                    break;

                case COMMANDS:
                    showCommands();
                    break;

                case SETTINGS:
                    showSettings();
                    break;

                case GUIDE:
                    sendServerAction(GUIDE);
                    break;

                default:
                    sendServerAction(id);
                    break;
            }

        }, 200);
    }

    // =========================================================
    // الشخصية
    // =========================================================

    private void showCharacter() {

        menuTitle.setText("👤 الشخصية");

        dataDialogMenuArrayList.clear();

        addItem(
                CHARACTER_INFO,
                R.drawable.br_menu_menu,
                "📋 معلومات الشخصية"
        );

        addItem(
                CHARACTER_STATS,
                R.drawable.br_menu_menu,
                "📊 الإحصائيات"
        );

        addItem(
                CHARACTER_SKILLS,
                R.drawable.br_menu_menu,
                "⭐ المهارات"
        );

        addItem(
                CHARACTER_ACHIEVEMENTS,
                R.drawable.br_menu_menu,
                "🏆 الإنجازات"
        );

        addItem(
                CHARACTER_WARNINGS,
                R.drawable.br_menu_menu,
                "⚠️ التحذيرات"
        );

        addItem(
                CHARACTER_APPEARANCE,
                R.drawable.br_menu_menu,
                "👕 المظهر"
        );

        addItem(
                CHARACTER_STATUS,
                R.drawable.br_menu_menu,
                "😴 الحالة"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // المركبات
    // =========================================================

    private void showVehicles() {

        menuTitle.setText("🚗 المركبات");

        dataDialogMenuArrayList.clear();

        addItem(
                MY_VEHICLES,
                R.drawable.br_menu_car,
                "🚘 مركباتي"
        );

        addItem(
                VEHICLE_SPAWN,
                R.drawable.br_menu_car,
                "🚗 استدعاء مركبة"
        );

        addItem(
                VEHICLE_PARK,
                R.drawable.br_menu_car,
                "🅿️ إيقاف المركبة"
        );

        addItem(
                VEHICLE_LOCK,
                R.drawable.br_menu_car,
                "🔐 قفل / فتح المركبة"
        );

        addItem(
                VEHICLE_ENGINE,
                R.drawable.br_menu_car,
                "🔑 تشغيل / إطفاء المحرك"
        );

        addItem(
                VEHICLE_INFO,
                R.drawable.br_menu_car,
                "📋 معلومات المركبة"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // البنك والمالية
    // =========================================================

    private void showFinance() {

        menuTitle.setText("💰 البنك والمالية");

        dataDialogMenuArrayList.clear();

        addItem(
                BANK_BALANCE,
                R.drawable.br_menu_ruble,
                "💵 الرصيد"
        );

        addItem(
                BANK_DEPOSIT,
                R.drawable.br_menu_ruble,
                "📥 إيداع"
        );

        addItem(
                BANK_WITHDRAW,
                R.drawable.br_menu_ruble,
                "📤 سحب"
        );

        addItem(
                BANK_TRANSFER,
                R.drawable.br_menu_ruble,
                "💸 تحويل أموال"
        );

        addItem(
                BANK_TRANSACTIONS,
                R.drawable.br_menu_ruble,
                "📜 سجل العمليات"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الوظائف
    // =========================================================

    private void showJobs() {

        menuTitle.setText("💼 الوظائف");

        dataDialogMenuArrayList.clear();

        addItem(
                JOB_INFO,
                R.drawable.br_menu_menu,
                "📋 معلومات الوظيفة"
        );

        addItem(
                JOB_START,
                R.drawable.br_menu_menu,
                "▶️ بدء العمل"
        );

        addItem(
                JOB_STOP,
                R.drawable.br_menu_menu,
                "⏹️ إنهاء العمل"
        );

        addItem(
                JOB_SKILL,
                R.drawable.br_menu_menu,
                "⭐ مهارة الوظيفة"
        );

        addItem(
                JOB_SALARY,
                R.drawable.br_menu_ruble,
                "💵 أرباح الوظيفة"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // العقارات
    // =========================================================

    private void showProperties() {

        menuTitle.setText("🏠 العقارات");

        dataDialogMenuArrayList.clear();

        addItem(
                MY_PROPERTIES,
                R.drawable.br_menu_menu,
                "🏠 عقاراتي"
        );

        addItem(
                PROPERTY_INFO,
                R.drawable.br_menu_menu,
                "📋 معلومات العقار"
        );

        addItem(
                PROPERTY_ENTER,
                R.drawable.br_menu_menu,
                "🚪 دخول العقار"
        );

        addItem(
                PROPERTY_STORAGE,
                R.drawable.br_menu_bag,
                "📦 مخزن العقار"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الرخص
    // =========================================================

    private void showLicenses() {

        menuTitle.setText("🪪 الرخص");

        dataDialogMenuArrayList.clear();

        addItem(
                LICENSE_CAR,
                R.drawable.br_menu_chat
                "🚗 رخصة قيادة سيارة"
        );

        addItem(
                LICENSE_BIKE,
                R.drawable.br_menu_chat
                "🏍️ رخصة دراجة"
        );

        addItem(
                LICENSE_WEAPON,
                R.drawable.br_menu_chat
                "🔫 رخصة سلاح"
        );

        addItem(
                LICENSE_TRUCK,
                R.drawable.br_menu_chat
                "🚚 رخصة شاحنة"
        );

        addItem(
                LICENSE_AIRCRAFT,
                R.drawable.br_menu_chat
                "✈️ رخصة طيران"
        );

        addItem(
                LICENSE_BOAT,
                R.drawable.br_menu_chat
                "🚤 رخصة قارب"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الحقيبة
    // =========================================================

    private void showInventory() {

        menuTitle.setText("🎒 الحقيبة");

        dataDialogMenuArrayList.clear();

        addItem(
                INVENTORY_ITEMS,
                R.drawable.br_menu_bag,
                "📦 الأغراض"
        );

        addItem(
                INVENTORY_WEAPONS,
                R.drawable.br_menu_bag,
                "🔫 الأسلحة"
        );

        addItem(
                INVENTORY_KEYS,
                R.drawable.br_menu_bag,
                "🔑 المفاتيح"
        );

        addItem(
                INVENTORY_DOCUMENTS,
                R.drawable.br_menu_chat
                "🪪 الوثائق"
        );

        addItem(
                INVENTORY_MATERIALS,
                R.drawable.br_menu_bag,
                "🧱 المواد"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // المهام
    // =========================================================

    private void showMissions() {

        menuTitle.setText("🎯 المهام");

        dataDialogMenuArrayList.clear();

        addItem(
                DAILY_MISSIONS,
                R.drawable.br_menu_menu,
                "📅 المهام اليومية"
        );

        addItem(
                JOB_MISSIONS,
                R.drawable.br_menu_menu,
                "💼 مهام الوظيفة"
        );

        addItem(
                GANG_MISSIONS,
                R.drawable.br_menu_menu,
                "🏴 مهام العصابة"
        );

        addItem(
                POLICE_MISSIONS,
                R.drawable.br_menu_menu,
                "👮 مهام الشرطة"
        );

        addItem(
                MISSION_REWARDS,
                R.drawable.br_menu_ruble,
                "🎁 المكافآت"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الأوامر
    // =========================================================

    private void showCommands() {

        menuTitle.setText("📋 الأوامر");

        dataDialogMenuArrayList.clear();

        addItem(
                1900,
                R.drawable.br_menu_menu,
                "💬 أوامر المحادثة"
        );

        addItem(
                1901,
                R.drawable.br_menu_menu,
                "🎭 أوامر RP"
        );

        addItem(
                1902,
                R.drawable.br_menu_menu,
                "🚗 أوامر المركبات"
        );

        addItem(
                1903,
                R.drawable.br_menu_menu,
                "👤 أوامر الشخصية"
        );

        addItem(
                1904,
                R.drawable.br_menu_menu,
                "🏴 أوامر العصابة"
        );

        addItem(
                1905,
                R.drawable.br_menu_menu,
                "👮 أوامر الشرطة"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الإعدادات
    // =========================================================

    private void showSettings() {

        menuTitle.setText("⚙️ الإعدادات");

        dataDialogMenuArrayList.clear();

        addItem(
                SETTINGS_CHAT,
                R.drawable.br_menu_menu,
                "💬 إعدادات الشات"
        );

        addItem(
                SETTINGS_CONTROLS,
                R.drawable.br_menu_menu,
                "🎮 التحكم"
        );

        addItem(
                SETTINGS_GRAPHICS,
                R.drawable.br_menu_menu,
                "🎨 الرسومات"
        );

        addItem(
                SETTINGS_SOUND,
                R.drawable.br_menu_menu,
                "🔊 الصوت"
        );

        addItem(
                SETTINGS_INTERFACE,
                R.drawable.br_menu_menu,
                "🖥️ الواجهة"
        );

        addItem(
                MAIN_MENU,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == MAIN_MENU) {
                        showMainMenu();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الملاحة
    // =========================================================

    private void showNavigation() {

        menuTitle.setText("🗺️ الملاحة");

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
                this::navigationClick
        );
    }

    private void navigationClick(
            DataDialogMenu item,
            View view
    ) {

        view.startAnimation(anim);

        new Handler().postDelayed(() -> {

            switch (item.getId()) {

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

        menuTitle.setText("🏛️ المنظمات الحكومية");

        dataDialogMenuArrayList.clear();

        addItem(POLICE, R.drawable.br_menu_menu, "👮 الشرطة");
        addItem(AMBULANCE, R.drawable.br_menu_menu, "🚑 الإسعاف");
        addItem(FIRE_DEPARTMENT, R.drawable.br_menu_menu, "🚒 الإطفاء");
        addItem(MECHANIC, R.drawable.br_menu_menu, "🔧 الميكانيكي");
        addItem(TAXI, R.drawable.br_menu_menu, "🚕 التاكسي");
        addItem(COURT, R.drawable.br_menu_menu, "⚖️ المحكمة");
        addItem(GOVERNMENT_ORG, R.drawable.br_menu_menu, "🏛️ الحكومة");
        addItem(ARMY, R.drawable.br_menu_menu, "🪖 الجيش");

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
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

        menuTitle.setText("🔫 المنظمات غير الشرعية");

        dataDialogMenuArrayList.clear();

        addItem(GANGS, R.drawable.br_menu_menu, "🏴 العصابات");
        addItem(MAFIA, R.drawable.br_menu_menu, "💀 المافيا");
        addItem(SECRET_ORGS, R.drawable.br_menu_menu, "🕶️ المنظمات السرية");
        addItem(GANG_WAREHOUSES, R.drawable.br_menu_menu, "📦 مخازن العصابات");
        addItem(WAR_ZONES, R.drawable.br_menu_menu, "🔥 مناطق الحروب");

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
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

        menuTitle.setText("🏴 العصابات");

        dataDialogMenuArrayList.clear();

        addItem(VAGOS, R.drawable.br_menu_menu, "🟡 Vagos");
        addItem(BALLAS, R.drawable.br_menu_menu, "🟣 Ballas");
        addItem(FAMILIES, R.drawable.br_menu_menu, "🟢 Families");
        addItem(AZTECAS, R.drawable.br_menu_menu, "🔵 Aztecas");
        addItem(GROVE, R.drawable.br_menu_menu, "🟢 Grove Street");

        addItem(
                ILLEGAL,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
                (item, view) -> {

                    if (item.getId() == ILLEGAL) {
                        showIllegalOrganizations();
                    } else {
                        showGangBase(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // مقر العصابة
    // =========================================================

    private void showGangBase(int gangId) {

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
                2100 + gangId,
                R.drawable.br_menu_compass,
                "📍 تحديد مقر العصابة"
        );

        addItem(
                2200 + gangId,
                R.drawable.br_menu_menu,
                "📋 معلومات العصابة"
        );

        addItem(
                2300 + gangId,
                R.drawable.br_menu_car,
                "🚗 مركبات العصابة"
        );

        addItem(
                2400 + gangId,
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
                (item, view) -> {

                    if (item.getId() == GANGS) {
                        showGangs();
                    } else {
                        sendServerAction(item.getId());
                    }

                }
        );
    }

    // =========================================================
    // الأماكن
    // =========================================================

    private void showLocations() {

        menuTitle.setText("📍 الأماكن والمواقع");

        dataDialogMenuArrayList.clear();

        addItem(BANKS, R.drawable.br_menu_menu, "🏦 البنوك");
        addItem(STORES, R.drawable.br_menu_menu, "🏪 المتاجر");
        addItem(HOSPITALS, R.drawable.br_menu_menu, "🏥 المستشفيات");
        addItem(GAS_STATIONS, R.drawable.br_menu_menu, "⛽ محطات الوقود");
        addItem(CLOTHING, R.drawable.br_menu_menu, "👕 محلات الملابس");
        addItem(WEAPON_SHOPS, R.drawable.br_menu_menu, "🔫 متاجر الأسلحة");
        addItem(CASINO, R.drawable.br_menu_menu, "🎰 الكازينو");
        addItem(AIRPORT, R.drawable.br_menu_menu, "✈️ المطار");
        addItem(PORT, R.drawable.br_menu_menu, "🚢 الميناء");
        addItem(POLICE_STATION, R.drawable.br_menu_menu, "👮 مراكز الشرطة");
        addItem(MECHANIC_SHOPS, R.drawable.br_menu_menu, "🔧 ورش الميكانيكي");
        addItem(RESTAURANTS, R.drawable.br_menu_menu, "🍔 المطاعم");
        addItem(BARBERS, R.drawable.br_menu_menu, "💈 الحلاق");
        addItem(ATM, R.drawable.br_menu_menu, "💳 أجهزة الصراف");

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
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
    // معارض السيارات
    // =========================================================

    private void showCarDealerships() {

        menuTitle.setText("🚗 معارض السيارات");

        dataDialogMenuArrayList.clear();

        addItem(
                3000,
                R.drawable.br_menu_car,
                "🚗 المعرض الرئيسي"
        );

        addItem(
                3001,
                R.drawable.br_menu_car,
                "🏎️ السيارات الرياضية"
        );

        addItem(
                3002,
                R.drawable.br_menu_car,
                "🚙 السيارات الفاخرة"
        );

        addItem(
                3003,
                R.drawable.br_menu_car,
                "🚘 السيارات العائلية"
        );

        addItem(
                3004,
                R.drawable.br_menu_car,
                "🚐 المركبات التجارية"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
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
    // معارض الدراجات
    // =========================================================

    private void showBikeDealerships() {

        menuTitle.setText("🏍️ معارض الدراجات");

        dataDialogMenuArrayList.clear();

        addItem(
                3100,
                R.drawable.br_menu_car,
                "🏍️ معرض الدراجات الرئيسي"
        );

        addItem(
                3101,
                R.drawable.br_menu_car,
                "🏁 الدراجات الرياضية"
        );

        addItem(
                3102,
                R.drawable.br_menu_car,
                "🛵 الدراجات المدنية"
        );

        addItem(
                NAVIGATION,
                R.drawable.menu_back,
                "↩️ رجوع"
        );

        showRecycler(
                2,
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
    // إضافة عنصر
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
    // RecyclerView
    // =========================================================

    private void showRecycler(
            int columns,
            DialogMenuAdapter.OnUserClickListener listener
    ) {

        RecyclerView recyclerView =
                activity.findViewById(
                        R.id.br_rec_view_menu
                );

        DialogMenuAdapter adapter =
                new DialogMenuAdapter(
                        dataDialogMenuArrayList,
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

    // =========================================================
    // إرسال للسيرفر
    // =========================================================

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

    // =========================================================
    // إغلاق
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
