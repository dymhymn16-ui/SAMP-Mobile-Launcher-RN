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

    // =========================
    // الأقسام الرئيسية
    // =========================

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

    // =========================
    // الملاحة
    // =========================

    private static final int GOVERNMENT = 20;
    private static final int ILLEGAL = 21;
    private static final int DEALERSHIPS = 22;
    private static final int BIKE_DEALERSHIPS = 23;
    private static final int LOCATIONS = 24;

    // =========================
    // المنظمات الحكومية
    // =========================

    private static final int POLICE = 100;
    private static final int AMBULANCE = 101;
    private static final int FIRE_DEPARTMENT = 102;
    private static final int MECHANIC = 103;
    private static final int TAXI = 104;
    private static final int COURT = 105;
    private static final int GOVERNMENT_ORG = 106;
    private static final int ARMY = 107;

    // =========================
    // المنظمات غير الشرعية
    // =========================

    private static final int GANGS = 200;
    private static final int MAFIA = 201;
    private static final int SECRET_ORGS = 202;
    private static final int GANG_WAREHOUSES = 203;
    private static final int WAR_ZONES = 204;

    // =========================
    // العصابات
    // =========================

    private static final int VAGOS = 300;
    private static final int BALLAS = 301;
    private static final int FAMILIES = 302;
    private static final int AZTECAS = 303;
    private static final int GROVE = 304;

    // =========================
    // الأماكن
    // =========================

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

    // =========================
    // الشخصية
    // =========================

    private static final int CHARACTER_INFO = 1000;
    private static final int CHARACTER_STATS = 1001;
    private static final int CHARACTER_SKILLS = 1002;
    private static final int CHARACTER_ACHIEVEMENTS = 1003;
    private static final int CHARACTER_WARNINGS = 1004;
    private static final int CHARACTER_APPEARANCE = 1005;
    private static final int CHARACTER_STATUS = 1006;

    // =========================
    // المركبات
    // =========================

    private static final int MY_VEHICLES = 1100;
    private static final int VEHICLE_SPAWN = 1101;
    private static final int VEHICLE_PARK = 1102;
    private static final int VEHICLE_LOCK = 1103;
    private static final int VEHICLE_ENGINE = 1104;
    private static final int VEHICLE_INFO = 1105;

    // =========================
    // البنك
    // =========================

    private static final int BANK_BALANCE = 1200;
    private static final int BANK_DEPOSIT = 1201;
    private static final int BANK_WITHDRAW = 1202;
    private static final int BANK_TRANSFER = 1203;
    private static final int BANK_TRANSACTIONS = 1204;

    // =========================
    // الوظائف
    // =========================

    private static final int JOB_INFO = 1300;
    private static final int JOB_START = 1301;
    private static final int JOB_STOP = 1302;
    private static final int JOB_SKILL = 1303;
    private static final int JOB_SALARY = 1304;

    // =========================
    // العقارات
    // =========================

    private static final int MY_PROPERTIES = 1400;
    private static final int PROPERTY_INFO = 1401;
    private static final int PROPERTY_ENTER = 1402;
    private static final int PROPERTY_STORAGE = 1403;

    // =========================
    // الرخص
    // =========================

    private static final int LICENSE_CAR = 1500;
    private static final int LICENSE_BIKE = 1501;
    private static final int LICENSE_WEAPON = 1502;
    private static final int LICENSE_TRUCK = 1503;
    private static final int LICENSE_AIRCRAFT = 1504;
    private static final int LICENSE_BOAT = 1505;

    // =========================
    // الحقيبة
    // =========================

    private static final int INVENTORY_ITEMS = 1600;
    private static final int INVENTORY_WEAPONS = 1601;
    private static final int INVENTORY_KEYS = 1602;
    private static final int INVENTORY_DOCUMENTS = 1603;
    private static final int INVENTORY_MATERIALS = 1604;

    // =========================
    // المهام
    // =========================

    private static final int DAILY_MISSIONS = 1700;
    private static final int JOB_MISSIONS = 1701;
    private static final int GANG_MISSIONS = 1702;
    private static final int POLICE_MISSIONS = 1703;
    private static final int MISSION_REWARDS = 1704;

    // =========================
    // الإعدادات
    // =========================

    private static final int SETTINGS_CHAT = 1800;
    private static final int SETTINGS_CONTROLS = 1801;
    private static final int SETTINGS_GRAPHICS = 1802;
    private static final int SETTINGS_SOUND = 1803;
    private static final int SETTINGS_INTERFACE = 1804;

    // =========================
    // الإنشاء
    // =========================

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

        View closeButton = aactivity.findViewById(
                R.id.br_menu_close_new
        );

        if (closeButton != null) {
            closeButton.setOnClickListener(view -> close());
        }

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

    // =========================
    // فتح القائمة
    // =========================

    public void ShowMenu() {

        showMainMenu();

        Utils.ShowLayout(
                menu_layout,
                true
        );
    }

    // =========================
    // القائمة الرئيسية
    // =========================

    private void showMainMenu() {

        menuTitle = activity.findViewById(
                R.id.br_menu_title
        );

        if (menuTitle != null) {
            menuTitle.setText("☰ NAVARA ROLEPLAY");
        }

         dataDialogMenuArrayList.clear();

        // القائمة الرئيسية
        addMenuItem(
                "👤 الشخصية",
                CHARACTER,
                R.drawable.br_menu_chat
        );

        addMenuItem(
                "🧭 الملاحة",
                NAVIGATION,
                R.drawable.br_menu_compass
        );

        addMenuItem(
                "🚗 المركبات",
                VEHICLES,
                R.drawable.br_menu_car
        );

        addMenuItem(
                "💰 البنك والمالية",
                FINANCE,
                R.drawable.br_menu_ruble
        );

        addMenuItem(
                "💼 الوظائف",
                JOBS,
                R.drawable.br_menu_bag
        );

        addMenuItem(
                "🏠 العقارات",
                PROPERTIES,
                R.drawable.br_menu_menu
        );

        addMenuItem(
                "📜 الرخص",
                LICENSES,
                R.drawable.br_menu_chat
        );

        addMenuItem(
                "🎒 الحقيبة",
                INVENTORY,
                R.drawable.br_menu_bag
        );

        addMenuItem(
                "🎯 المهام",
                MISSIONS,
                R.drawable.br_menu_compass
        );

        addMenuItem(
                "⚔️ السيطرة",
                CAPTURE,
                R.drawable.br_menu_car
        );

        addMenuItem(
                "📋 الأوامر",
                COMMANDS,
                R.drawable.br_menu_menu
        );

        addMenuItem(
                "⚙️ الإعدادات",
                SETTINGS,
                R.drawable.br_menu_menu
        );

        addMenuItem(
                "📖 دليل NAVARA",
                GUIDE,
                R.drawable.br_menu_chat
        );

        showRecycler(2, this::mainMenuClick);
    }

    // =========================
    // إضافة عنصر للقائمة
    // =========================

    private void addMenuItem(
            String title,
            int id,
            int icon
    ) {
        dataDialogMenuArrayList.add(
                new DataDialogMenu(
                        title,
                        icon,
                        id
                )
        );
    }

    // =========================
    // الضغط على القائمة الرئيسية
    // =========================

    private void mainMenuClick(
            int position,
            DataDialogMenu item
    ) {

        switch (item.getId()) {

            case CHARACTER:
                showCharacterMenu();
                break;

            case NAVIGATION:
                showNavigationMenu();
                break;

            case VEHICLES:
                showVehiclesMenu();
                break;

            case FINANCE:
                showFinanceMenu();
                break;

            case JOBS:
                showJobsMenu();
                break;

            case PROPERTIES:
                showPropertiesMenu();
                break;

            case LICENSES:
                showLicensesMenu();
                break;

            case INVENTORY:
                showInventoryMenu();
                break;

            case MISSIONS:
                showMissionsMenu();
                break;

            case CAPTURE:
                showCaptureMenu();
                break;

            case COMMANDS:
                showCommandsMenu();
                break;

            case SETTINGS:
                showSettingsMenu();
                break;

            case GUIDE:
                showGuideMenu();
                break;
        }
    }

    // =========================
    // الشخصية
    // =========================

    private void showCharacterMenu() {

        prepareSubMenu("👤 الشخصية");

        addMenuItem("📋 معلومات الشخصية", CHARACTER_INFO, R.drawable.br_menu_chat);
        addMenuItem("📊 الإحصائيات", CHARACTER_STATS, R.drawable.br_menu_ruble);
        addMenuItem("⭐ المهارات", CHARACTER_SKILLS, R.drawable.br_menu_compass);
        addMenuItem("🏆 الإنجازات", CHARACTER_ACHIEVEMENTS, R.drawable.br_menu_menu);
        addMenuItem("⚠️ التحذيرات", CHARACTER_WARNINGS, R.drawable.br_menu_chat);
        addMenuItem("👕 المظهر", CHARACTER_APPEARANCE, R.drawable.br_menu_bag);
        addMenuItem("❤️ الحالة", CHARACTER_STATUS, R.drawable.br_menu_chat);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الملاحة
    // =========================

    private void showNavigationMenu() {

        prepareSubMenu("🧭 الملاحة");

        addMenuItem("🏛️ حكومي", GOVERNMENT, R.drawable.br_menu_menu);
        addMenuItem("🔫 غير شرعي", ILLEGAL, R.drawable.br_menu_car);
        addMenuItem("🚘 معارض السيارات", DEALERSHIPS, R.drawable.br_menu_car);
        addMenuItem("🏍️ معارض الدراجات", BIKE_DEALERSHIPS, R.drawable.br_menu_car);
        addMenuItem("📍 جميع المواقع", LOCATIONS, R.drawable.br_menu_compass);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // المركبات
    // =========================

    private void showVehiclesMenu() {

        prepareSubMenu("🚗 المركبات");

        addMenuItem("🚘 مركباتي", MY_VEHICLES, R.drawable.br_menu_car);
        addMenuItem("📍 استدعاء المركبة", VEHICLE_SPAWN, R.drawable.br_menu_compass);
        addMenuItem("🅿️ إيقاف المركبة", VEHICLE_PARK, R.drawable.br_menu_car);
        addMenuItem("🔒 قفل المركبة", VEHICLE_LOCK, R.drawable.br_menu_chat);
        addMenuItem("🔑 تشغيل المحرك", VEHICLE_ENGINE, R.drawable.br_menu_car);
        addMenuItem("ℹ️ معلومات المركبة", VEHICLE_INFO, R.drawable.br_menu_menu);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // البنك
    // =========================

    private void showFinanceMenu() {

        prepareSubMenu("💰 البنك والمالية");

        addMenuItem("💵 الرصيد", BANK_BALANCE, R.drawable.br_menu_ruble);
        addMenuItem("🏦 إيداع", BANK_DEPOSIT, R.drawable.br_menu_ruble);
        addMenuItem("💸 سحب", BANK_WITHDRAW, R.drawable.br_menu_ruble);
        addMenuItem("🔄 تحويل", BANK_TRANSFER, R.drawable.br_menu_ruble);
        addMenuItem("📜 العمليات المالية", BANK_TRANSACTIONS, R.drawable.br_menu_chat);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الوظائف
    // =========================

    private void showJobsMenu() {

        prepareSubMenu("💼 الوظائف");

        addMenuItem("ℹ️ معلومات الوظيفة", JOB_INFO, R.drawable.br_menu_chat);
        addMenuItem("▶️ بدء العمل", JOB_START, R.drawable.br_menu_car);
        addMenuItem("⏹️ إيقاف العمل", JOB_STOP, R.drawable.br_menu_car);
        addMenuItem("📈 مهارة الوظيفة", JOB_SKILL, R.drawable.br_menu_compass);
        addMenuItem("💵 الراتب", JOB_SALARY, R.drawable.br_menu_ruble);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // العقارات
    // =========================

    private void showPropertiesMenu() {

        prepareSubMenu("🏠 العقارات");

        addMenuItem("🏠 عقاراتي", MY_PROPERTIES, R.drawable.br_menu_menu);
        addMenuItem("ℹ️ معلومات العقار", PROPERTY_INFO, R.drawable.br_menu_chat);
        addMenuItem("🚪 دخول العقار", PROPERTY_ENTER, R.drawable.br_menu_menu);
        addMenuItem("📦 مخزن العقار", PROPERTY_STORAGE, R.drawable.br_menu_bag);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الرخص
    // =========================

    private void showLicensesMenu() {

        prepareSubMenu("📜 الرخص");

        addMenuItem("🚗 رخصة سيارة", LICENSE_CAR, R.drawable.br_menu_car);
        addMenuItem("🏍️ رخصة دراجة", LICENSE_BIKE, R.drawable.br_menu_car);
        addMenuItem("🔫 رخصة سلاح", LICENSE_WEAPON, R.drawable.br_menu_car);
        addMenuItem("🚛 رخصة شاحنة", LICENSE_TRUCK, R.drawable.br_menu_car);
        addMenuItem("✈️ رخصة طائرة", LICENSE_AIRCRAFT, R.drawable.br_menu_car);
        addMenuItem("🚤 رخصة قارب", LICENSE_BOAT, R.drawable.br_menu_car);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الحقيبة
    // =========================

    private void showInventoryMenu() {

        prepareSubMenu("🎒 الحقيبة");

        addMenuItem("📦 الأدوات", INVENTORY_ITEMS, R.drawable.br_menu_bag);
        addMenuItem("🔫 الأسلحة", INVENTORY_WEAPONS, R.drawable.br_menu_car);
        addMenuItem("🔑 المفاتيح", INVENTORY_KEYS, R.drawable.br_menu_chat);
        addMenuItem("📄 المستندات", INVENTORY_DOCUMENTS, R.drawable.br_menu_chat);
        addMenuItem("🧱 المواد", INVENTORY_MATERIALS, R.drawable.br_menu_bag);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // المهام
    // =========================

    private void showMissionsMenu() {

        prepareSubMenu("🎯 المهام");

        addMenuItem("📅 المهام اليومية", DAILY_MISSIONS, R.drawable.br_menu_compass);
        addMenuItem("💼 مهام الوظائف", JOB_MISSIONS, R.drawable.br_menu_bag);
        addMenuItem("🔫 مهام العصابات", GANG_MISSIONS, R.drawable.br_menu_car);
        addMenuItem("👮 مهام الشرطة", POLICE_MISSIONS, R.drawable.br_menu_car);
        addMenuItem("🎁 مكافآت المهام", MISSION_REWARDS, R.drawable.br_menu_ruble);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // السيطرة
    // =========================

    private void showCaptureMenu() {

        prepareSubMenu("⚔️ السيطرة");

        addMenuItem("🗺️ مناطق السيطرة", CAPTURE, R.drawable.br_menu_compass);
        addMenuItem("⚔️ مناطق الحرب", WAR_ZONES, R.drawable.br_menu_car);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الأوامر
    // =========================

    private void showCommandsMenu() {

        prepareSubMenu("📋 الأوامر");

        addMenuItem("👤 أوامر الشخصية", CHARACTER, R.drawable.br_menu_chat);
        addMenuItem("🚗 أوامر المركبات", VEHICLES, R.drawable.br_menu_car);
        addMenuItem("💰 أوامر البنك", FINANCE, R.drawable.br_menu_ruble);
        addMenuItem("💼 أوامر الوظائف", JOBS, R.drawable.br_menu_bag);
        addMenuItem("🎒 أوامر الحقيبة", INVENTORY, R.drawable.br_menu_bag);
        addMenuItem("🎯 أوامر المهام", MISSIONS, R.drawable.br_menu_compass);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الإعدادات
    // =========================

    private void showSettingsMenu() {

        prepareSubMenu("⚙️ الإعدادات");

        addMenuItem("💬 إعدادات الشات", SETTINGS_CHAT, R.drawable.br_menu_chat);
        addMenuItem("🎮 التحكم", SETTINGS_CONTROLS, R.drawable.br_menu_menu);
        addMenuItem("🎨 الرسومات", SETTINGS_GRAPHICS, R.drawable.br_menu_compass);
        addMenuItem("🔊 الصوت", SETTINGS_SOUND, R.drawable.br_menu_chat);
        addMenuItem("🖥️ الواجهة", SETTINGS_INTERFACE, R.drawable.br_menu_menu);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // الدليل
    // =========================

    private void showGuideMenu() {

        prepareSubMenu("📖 دليل NAVARA");

        addMenuItem("👤 دليل الشخصية", CHARACTER, R.drawable.br_menu_chat);
        addMenuItem("🚗 دليل المركبات", VEHICLES, R.drawable.br_menu_car);
        addMenuItem("💰 دليل البنك", FINANCE, R.drawable.br_menu_ruble);
        addMenuItem("🏠 دليل العقارات", PROPERTIES, R.drawable.br_menu_menu);
        addMenuItem("🎯 دليل المهام", MISSIONS, R.drawable.br_menu_compass);

        showRecycler(2, this::subMenuClick);
    }

    // =========================
    // تجهيز القائمة الفرعية
    // =========================

    private void prepareSubMenu(String title) {

        menuTitle = activity.findViewById(
                R.id.br_menu_title
        );

        if (menuTitle != null) {
            menuTitle.setText(title);
        }

        dataDialogMenuArrayList.clear();
    }

    // =========================
    // ضغط القائمة الفرعية
    // =========================

    private void subMenuClick(
            int position,
            DataDialogMenu item
    ) {

        switch (item.getId()) {

            // الشخصية
            case CHARACTER_INFO:
            case CHARACTER_STATS:
            case CHARACTER_SKILLS:
            case CHARACTER_ACHIEVEMENTS:
            case CHARACTER_WARNINGS:
            case CHARACTER_APPEARANCE:
            case CHARACTER_STATUS:
                showMessage("👤 سيتم فتح قسم الشخصية قريباً.");
                break;

            // المركبات
            case MY_VEHICLES:
            case VEHICLE_SPAWN:
            case VEHICLE_PARK:
            case VEHICLE_LOCK:
            case VEHICLE_ENGINE:
            case VEHICLE_INFO:
                showMessage("🚗 سيتم فتح نظام المركبات قريباً.");
                break;

            // البنك
            case BANK_BALANCE:
            case BANK_DEPOSIT:
            case BANK_WITHDRAW:
            case BANK_TRANSFER:
            case BANK_TRANSACTIONS:
                showMessage("💰 سيتم فتح نظام البنك قريباً.");
                break;

            // الوظائف
            case JOB_INFO:
            case JOB_START:
            case JOB_STOP:
            case JOB_SKILL:
            case JOB_SALARY:
                showMessage("💼 سيتم فتح نظام الوظائف قريباً.");
                break;

            // العقارات
            case MY_PROPERTIES:
            case PROPERTY_INFO:
            case PROPERTY_ENTER:
            case PROPERTY_STORAGE:
                showMessage("🏠 سيتم فتح نظام العقارات قريباً.");
                break;

            // الرخص
            case LICENSE_CAR:
            case LICENSE_BIKE:
            case LICENSE_WEAPON:
            case LICENSE_TRUCK:
            case LICENSE_AIRCRAFT:
            case LICENSE_BOAT:
                showMessage("📜 سيتم فتح نظام الرخص قريباً.");
                break;

            // الحقيبة
            case INVENTORY_ITEMS:
            case INVENTORY_WEAPONS:
            case INVENTORY_KEYS:
            case INVENTORY_DOCUMENTS:
            case INVENTORY_MATERIALS:
                showMessage("🎒 سيتم فتح الحقيبة قريباً.");
                break;

            // المهام
            case DAILY_MISSIONS:
            case JOB_MISSIONS:
            case GANG_MISSIONS:
            case POLICE_MISSIONS:
            case MISSION_REWARDS:
                showMessage("🎯 سيتم فتح نظام المهام قريباً.");
                break;

            // الإعدادات
            case SETTINGS_CHAT:
            case SETTINGS_CONTROLS:
            case SETTINGS_GRAPHICS:
            case SETTINGS_SOUND:
            case SETTINGS_INTERFACE:
                showMessage("⚙️ سيتم فتح الإعدادات قريباً.");
                break;

            // الملاحة
            case GOVERNMENT:
            case ILLEGAL:
            case DEALERSHIPS:
            case BIKE_DEALERSHIPS:
            case LOCATIONS:
                showMessage("🧭 سيتم فتح نظام الملاحة قريباً.");
                break;

            // السيطرة
            case CAPTURE:
            case WAR_ZONES:
                showMessage("⚔️ سيتم فتح نظام السيطرة والحروب قريباً.");
                break;

            default:
                showMessage("ℹ️ هذا القسم غير متاح حالياً.");
                break;
        }
    }

    // =========================
    // RecyclerView
    // =========================

    private void showRecycler(
            int columns,
            DialogMenuAdapter.OnUserClickListener listener
    ) {

        RecyclerView recyclerView =
                activity.findViewById(
                        R.id.br_menu_recycler
                );

        if (recyclerView == null) {
            return;
        }

        recyclerView.setLayoutManager(
                new GridLayoutManager(
                        activity,
                        columns
                )
        );

        DialogMenuAdapter adapter =
                new DialogMenuAdapter(
                        activity,
                        dataDialogMenuArrayList,
                        listener
                );

        recyclerView.setAdapter(adapter);

        recyclerView.startAnimation(anim);
    }

    // =========================
    // رسالة مؤقتة
    // =========================

    private void showMessage(String message) {

        if (menuTitle != null) {
            menuTitle.setText(message);
        }

        new Handler().postDelayed(
                () -> {

                    if (menuTitle != null) {
                        menuTitle.setText("☰ NAVARA ROLEPLAY");
                    }

                },
                1500
        );
    }

    // =========================
    // إغلاق القائمة
    // =========================

    public void close() {

        Utils.HideLayout(
                menu_layout,
                true
        );
    }
    }              
