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

import com.touch.mobile.dark.R;
import com.touch.mobile.dark.gui.adapters.DialogMenuAdapter;
import com.touch.mobile.dark.gui.models.DataDialogMenu;
import com.touch.mobile.dark.gui.util.Utils;

import java.util.ArrayList;

public class Menu {

    public View mRootView;
    public Activity activity;
    public LinearLayout menu_layout;
    public TextView menuTitle;

    private final Animation anim;

    private final ArrayList<DataDialogMenu> dataDialogMenuArrayList =
            new ArrayList<>();

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

    private static final int CHARACTER_INFO = 1000;
    private static final int CHARACTER_STATS = 1001;
    private static final int CHARACTER_SKILLS = 1002;
    private static final int CHARACTER_ACHIEVEMENTS = 1003;
    private static final int CHARACTER_WARNINGS = 1004;
    private static final int CHARACTER_APPEARANCE = 1005;
    private static final int CHARACTER_STATUS = 1006;

    private static final int MY_VEHICLES = 1100;
    private static final int VEHICLE_SPAWN = 1101;
    private static final int VEHICLE_PARK = 1102;
    private static final int VEHICLE_LOCK = 1103;
    private static final int VEHICLE_ENGINE = 1104;
    private static final int VEHICLE_INFO = 1105;

    private static final int BANK_BALANCE = 1200;
    private static final int BANK_DEPOSIT = 1201;
    private static final int BANK_WITHDRAW = 1202;
    private static final int BANK_TRANSFER = 1203;
    private static final int BANK_TRANSACTIONS = 1204;

    private static final int JOB_INFO = 1300;
    private static final int JOB_START = 1301;
    private static final int JOB_STOP = 1302;
    private static final int JOB_SKILL = 1303;
    private static final int JOB_SALARY = 1304;

    private static final int MY_PROPERTIES = 1400;
    private static final int PROPERTY_INFO = 1401;
    private static final int PROPERTY_ENTER = 1402;
    private static final int PROPERTY_STORAGE = 1403;

    private static final int LICENSE_CAR = 1500;
    private static final int LICENSE_BIKE = 1501;
    private static final int LICENSE_WEAPON = 1502;
    private static final int LICENSE_TRUCK = 1503;
    private static final int LICENSE_AIRCRAFT = 1504;
    private static final int LICENSE_BOAT = 1505;

    private static final int INVENTORY_ITEMS = 1600;
    private static final int INVENTORY_WEAPONS = 1601;
    private static final int INVENTORY_KEYS = 1602;
    private static final int INVENTORY_DOCUMENTS = 1603;
    private static final int INVENTORY_MATERIALS = 1604;

    private static final int DAILY_MISSIONS = 1700;
    private static final int JOB_MISSIONS = 1701;
    private static final int GANG_MISSIONS = 1702;
    private static final int POLICE_MISSIONS = 1703;
    private static final int MISSION_REWARDS = 1704;

    private static final int SETTINGS_CHAT = 1800;
    private static final int SETTINGS_CONTROLS = 1801;
    private static final int SETTINGS_GRAPHICS = 1802;
    private static final int SETTINGS_SOUND = 1803;
    private static final int SETTINGS_INTERFACE = 1804;

    private static final int GOVERNMENT = 2000;
    private static final int ILLEGAL = 2001;
    private static final int DEALERSHIPS = 2002;
    private static final int BIKE_DEALERSHIPS = 2003;
    private static final int LOCATIONS = 2004;

    private static final int WAR_ZONES = 2100;

    @SuppressLint("InflateParams")
    public Menu(Activity aactivity) {

     = aactivity;

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

    public void ShowMenu() {

        showMainMenu();

        Utils.ShowLayout(
                menu_layout,
                true
        );
    }

    private void showMainMenu() {

        setTitle("☰ NAVARA ROLEPLAY");

        dataDialogMenuArrayList.clear();

        addMenuItem(CHARACTER, R.drawable.br_menu_chat, "👤 الشخصية");
        addMenuItem(NAVIGATION, R.drawable.br_menu_compass, "🧭 الملاحة");
        addMenuItem(VEHICLES, R.drawable.br_menu_car, "🚗 المركبات");
        addMenuItem(FINANCE, R.drawable.br_menu_ruble, "💰 البنك والمالية");
        addMenuItem(JOBS, R.drawable.br_menu_bag, "💼 الوظائف");
        addMenuItem(PROPERTIES, R.drawable.br_menu_menu, "🏠 العقارات");
        addMenuItem(LICENSES, R.drawable.br_menu_chat, "📜 الرخص");
        addMenuItem(INVENTORY, R.drawable.br_menu_bag, "🎒 الحقيبة");
        addMenuItem(MISSIONS, R.drawable.br_menu_compass, "🎯 المهام");
        addMenuItem(CAPTURE, R.drawable.br_menu_car, "⚔️ السيطرة");
        addMenuItem(COMMANDS, R.drawable.br_menu_menu, "📋 الأوامر");
        addMenuItem(SETTINGS, R.drawable.br_menu_menu, "⚙️ الإعدادات");
        addMenuItem(GUIDE, R.drawable.br_menu_chat, "📖 دليل NAVARA");

        showRecycler(this::menuClick);
    }

    private void addMenuItem(
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

    private void menuClick(
            DataDialogMenu item,
            View view
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

            default:
                showSectionMessage(item.getNameButton());
                break;
        }
    }

    private void showCharacterMenu() {

        prepareSubMenu("👤 الشخصية");

        addMenuItem(CHARACTER_INFO, R.drawable.br_menu_chat, "📋 معلومات الشخصية");
        addMenuItem(CHARACTER_STATS, R.drawable.br_menu_ruble, "📊 الإحصائيات");
        addMenuItem(CHARACTER_SKILLS, R.drawable.br_menu_compass, "⭐ المهارات");
        addMenuItem(CHARACTER_ACHIEVEMENTS, R.drawable.br_menu_menu, "🏆 الإنجازات");
        addMenuItem(CHARACTER_WARNINGS, R.drawable.br_menu_chat, "⚠️ التحذيرات");
        addMenuItem(CHARACTER_APPEARANCE, R.drawable.br_menu_bag, "👕 المظهر");
        addMenuItem(CHARACTER_STATUS, R.drawable.br_menu_chat, "❤️ الحالة");

        showRecycler(this::subMenuClick);
    }

    private void showNavigationMenu() {

        prepareSubMenu("🧭 الملاحة");

        addMenuItem(GOVERNMENT, R.drawable.br_menu_menu, "🏛️ حكومي");
        addMenuItem(ILLEGAL, R.drawable.br_menu_car, "🔫 غير شرعي");
        addMenuItem(DEALERSHIPS, R.drawable.br_menu_car, "🚘 معارض السيارات");
        addMenuItem(BIKE_DEALERSHIPS, R.drawable.br_menu_car, "🏍️ معارض الدراجات");
        addMenuItem(LOCATIONS, R.drawable.br_menu_compass, "📍 جميع المواقع");

        showRecycler(this::subMenuClick);
    }

    private void showVehiclesMenu() {

        prepareSubMenu("🚗 المركبات");

        addMenuItem(MY_VEHICLES, R.drawable.br_menu_car, "🚘 مركباتي");
        addMenuItem(VEHICLE_SPAWN, R.drawable.br_menu_compass, "📍 استدعاء المركبة");
        addMenuItem(VEHICLE_PARK, R.drawable.br_menu_car, "🅿️ إيقاف المركبة");
        addMenuItem(VEHICLE_LOCK, R.drawable.br_menu_chat, "🔒 قفل المركبة");
        addMenuItem(VEHICLE_ENGINE, R.drawable.br_menu_car, "🔑 تشغيل المحرك");
        addMenuItem(VEHICLE_INFO, R.drawable.br_menu_menu, "ℹ️ معلومات المركبة");

        showRecycler(this::subMenuClick);
    }

    private void showFinanceMenu() {

        prepareSubMenu("💰 البنك والمالية");

        addMenuItem(BANK_BALANCE, R.drawable.br_menu_ruble, "💵 الرصيد");
        addMenuItem(BANK_DEPOSIT, R.drawable.br_menu_ruble, "🏦 إيداع");
        addMenuItem(BANK_WITHDRAW, R.drawable.br_menu_ruble, "💸 سحب");
        addMenuItem(BANK_TRANSFER, R.drawable.br_menu_ruble, "🔄 تحويل");
        addMenuItem(BANK_TRANSACTIONS, R.drawable.br_menu_chat, "📜 العمليات المالية");

        showRecycler(this::subMenuClick);
    }

    private void showJobsMenu() {

        prepareSubMenu("💼 الوظائف");

        addMenuItem(JOB_INFO, R.drawable.br_menu_chat, "ℹ️ معلومات الوظيفة");
        addMenuItem(JOB_START, R.drawable.br_menu_car, "▶️ بدء العمل");
        addMenuItem(JOB_STOP, R.drawable.br_menu_car, "⏹️ إيقاف العمل");
        addMenuItem(JOB_SKILL, R.drawable.br_menu_compass, "📈 مهارة الوظيفة");
        addMenuItem(JOB_SALARY, R.drawable.br_menu_ruble, "💵 الراتب");

        showRecycler(this::subMenuClick);
    }

    private void showPropertiesMenu() {

        prepareSubMenu("🏠 العقارات");

        addMenuItem(MY_PROPERTIES, R.drawable.br_menu_menu, "🏠 عقاراتي");
        addMenuItem(PROPERTY_INFO, R.drawable.br_menu_chat, "ℹ️ معلومات العقار");
        addMenuItem(PROPERTY_ENTER, R.drawable.br_menu_menu, "🚪 دخول العقار");
        addMenuItem(PROPERTY_STORAGE, R.drawable.br_menu_bag, "📦 مخزن العقار");

        showRecycler(this::subMenuClick);
    }

    private void showLicensesMenu() {

        prepareSubMenu("📜 الرخص");

        addMenuItem(LICENSE_CAR, R.drawable.br_menu_car, "🚗 رخصة سيارة");
        addMenuItem(LICENSE_BIKE, R.drawable.br_menu_car, "🏍️ رخصة دراجة");
        addMenuItem(LICENSE_WEAPON, R.drawable.br_menu_car, "🔫 رخصة سلاح");
        addMenuItem(LICENSE_TRUCK, R.drawable.br_menu_car, "🚛 رخصة شاحنة");
        addMenuItem(LICENSE_AIRCRAFT, R.drawable.br_menu_car, "✈️ رخصة طائرة");
        addMenuItem(LICENSE_BOAT, R.drawable.br_menu_car, "🚤 رخصة قارب");

        showRecycler(this::subMenuClick);
    }

    private void showInventoryMenu() {

        prepareSubMenu("🎒 الحقيبة");

        addMenuItem(INVENTORY_ITEMS, R.drawable.br_menu_bag, "📦 الأدوات");
        addMenuItem(INVENTORY_WEAPONS, R.drawable.br_menu_car, "🔫 الأسلحة");
        addMenuItem(INVENTORY_KEYS, R.drawable.br_menu_chat, "🔑 المفاتيح");
        addMenuItem(INVENTORY_DOCUMENTS, R.drawable.br_menu_chat, "📄 المستندات");
        addMenuItem(INVENTORY_MATERIALS, R.drawable.br_menu_bag, "🧱 المواد");

        showRecycler(this::subMenuClick);
    }

    private void showMissionsMenu() {

        prepareSubMenu("🎯 المهام");

        addMenuItem(DAILY_MISSIONS, R.drawable.br_menu_compass, "📅 المهام اليومية");
        addMenuItem(JOB_MISSIONS, R.drawable.br_menu_bag, "💼 مهام الوظائف");
        addMenuItem(GANG_MISSIONS, R.drawable.br_menu_car, "🔫 مهام العصابات");
        addMenuItem(POLICE_MISSIONS, R.drawable.br_menu_car, "👮 مهام الشرطة");
        addMenuItem(MISSION_REWARDS, R.drawable.br_menu_ruble, "🎁 مكافآت المهام");

        showRecycler(this::subMenuClick);
    }

    private void showCaptureMenu() {

        prepareSubMenu("⚔️ السيطرة");

        addMenuItem(CAPTURE, R.drawable.br_menu_compass, "🗺️ مناطق السيطرة");
        addMenuItem(WAR_ZONES, R.drawable.br_menu_car, "⚔️ مناطق الحرب");

        showRecycler(this::subMenuClick);
    }

    private void showCommandsMenu() {

        prepareSubMenu("📋 الأوامر");

        addMenuItem(CHARACTER, R.drawable.br_menu_chat, "👤 أوامر الشخصية");
        addMenuItem(VEHICLES, R.drawable.br_menu_car, "🚗 أوامر المركبات");
        addMenuItem(FINANCE, R.drawable.br_menu_ruble, "💰 أوامر البنك");
        addMenuItem(JOBS, R.drawable.br_menu_bag, "💼 أوامر الوظائف");
        addMenuItem(INVENTORY, R.drawable.br_menu_bag, "🎒 أوامر الحقيبة");
        addMenuItem(MISSIONS, R.drawable.br_menu_compass, "🎯 أوامر المهام");

        showRecycler(this::subMenuClick);
    }

    private void showSettingsMenu() {

        prepareSubMenu("⚙️ الإعدادات");

        addMenuItem(SETTINGS_CHAT, R.drawable.br_menu_chat, "💬 إعدادات الشات");
        addMenuItem(SETTINGS_CONTROLS, R.drawable.br_menu_menu, "🎮 التحكم");
        addMenuItem(SETTINGS_GRAPHICS, R.drawable.br_menu_compass, "🎨 الرسومات");
        addMenuItem(SETTINGS_SOUND, R.drawable.br_menu_chat, "🔊 الصوت");
        addMenuItem(SETTINGS_INTERFACE, R.drawable.br_menu_menu, "🖥️ الواجهة");

        showRecycler(this::subMenuClick);
    }

    private void showGuideMenu() {

        prepareSubMenu("📖 دليل NAVARA");

        addMenuItem(CHARACTER, R.drawable.br_menu_chat, "👤 دليل الشخصية");
        addMenuItem(VEHICLES, R.drawable.br_menu_car, "🚗 دليل المركبات");
        addMenuItem(FINANCE, R.drawable.br_menu_ruble, "💰 دليل البنك");
        addMenuItem(PROPERTIES, R.drawable.br_menu_menu, "🏠 دليل العقارات");
        addMenuItem(MISSIONS, R.drawable.br_menu_compass, "🎯 دليل المهام");

        showRecycler(this::subMenuClick);
    }

    private void prepareSubMenu(String title) {

        setTitle(title);

        dataDialogMenuArrayList.clear();
    }

    private void subMenuClick(
            DataDialogMenu item,
            View view
    ) {

        setTitle(item.getNameButton());

        // هنا ماكو رسالة "سيتم فتح النظام قريباً"
        // وإنما يثبت اسم القسم الذي ضغطت عليه.
    }

    private void showSectionMessage(String title) {

        setTitle(title);

        new Handler().postDelayed(
                () -> setTitle("☰ NAVARA ROLEPLAY"),
                1500
        );
    }

    private void setTitle(String title) {

        menuTitle = activity.findViewById(
                R.id.br_menu_title
        );

        if (menuTitle != null) {
            menuTitle.setText(title);
        }
    }

    private void showRecycler(
            DialogMenuAdapter.OnUserClickListener listener
    ) {

        RecyclerView recyclerView =
                activity.findViewById(
                        R.id.br_rec_view_menu
                );

        if (recyclerView == null) {
            return;
        }

        recyclerView.setLayoutManager(
                new GridLayoutManager(
                        activity,
                        2
                )
        );

        DialogMenuAdapter adapter =
                new DialogMenuAdapter(
                        dataDialogMenuArrayList,
                        listener
                );

        recyclerView.setAdapter(adapter);

        recyclerView.startAnimation(anim);
    }

    public void close() {

        Utils.HideLayout(
                menu_layout,
                true
        );
    }
                    }
