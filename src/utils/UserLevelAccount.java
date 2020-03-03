package utils;

public enum UserLevelAccount {
    //Complete Access Facility Level
    FACILITY_DEFAULT("FullAcFac-None", "Password123!"),
    FACILITY_MANAGE("FullAcFac-Man", "Password123!"),
    FACILITY_USER_MANAGE("FullAcFac-UM", "Password123!"),
    FACILITY_SELF("FullAcFac-Self","Password123!"),
    FACILITY_SUPER("FullAcFac-Super","Password123!"),

    //Complete Access Corporate Level
    COOPERATE_DEFAULT("FullAcCorp-None", "Password123!"),
    COOPERATE_MANAGE("FullAcCorp-Man", "Password123!"),
    COOPERATE_USER_MANAGE("FullAcCorp-UM", "Password123!"),
    COOPERATE_SELF("FullAcCorp-Self", "Password123!"),
    COOPERATE_SUPER("FullAcCorp-Super", "Password123!"),

    //Complete Access System Level
    SYSTEM_DEFAULT("FullAcSys-None", "Password123!"),
    SYSTEM_MANAGE("FullAcSys-Man", "Password123!"),
    SYSTEM_USER_MANAGE("FullAcSys-UM", "Password123!"),
    SYSTEM_SELF("FullAcSys-Self", "Password123!"),
    SYSTEM_SUPER("FullAcSys-Super", "Password123!"),

    //Complete Access Database Level
    DATABASE_DEFAULT("FullAcDataB-None", "Password123!"),
    DATABASE_MANAGE("FullAcDataB-Man", "Password123!"),
    DATABASE_USER_MANAGE("FullAcDataB-UM", "Password123!"),
    DATABASE_SELF("FullAcDataB-Self", "Password123!"),
    DATABASE_SUPER("FullAcDataB-Super", "Password123!"),

    //People Full Access + Settings - Facility Level
    PEOPLE_FACILITY_SETTING_Y("PplFac-Set-Y", "Password123!"),
    PEOPLE_FACILITY_SETTING_N("PplFac-Set-N","Password123!"),

    //Recipe Full Access + Settings - Facility Level
    RECIPIENT_FACILITY_SETTING_Y("RecFullFac-Set-Y","Password123!"),
    RECIPIENT_FACILITY_SETTING_N("RecFullFac-Set-N","Password123!"),
    //Recipe Full Access + Settings - Corp Level
    RECIPIENT_CORP_SETTING_Y("RecFullCorp-Set-Y","Password123!"),
    RECIPIENT_CORP_SETTING_N("RecFullCorp-Set-N","Password123!"),
    //Recipe Full Access + Settings - System Level
    RECIPIENT_SYS_SETTING_Y("RecFullSys-Set-Y","Password123!"),
    RECIPIENT_SYS_SETTING_N("RecFullSys-Set-N","Password123!"),
    //Recipe Full Access + Settings - Database Level
    RECIPIENT_DB_SETTING_Y("RecFullDataB-Set-Y","Password123!"),
    RECIPIENT_DB_SETTING_N("RecFullDataB-Set-N","Password123!"),
    //Recipe Read/Print Only + Settings - Facility Level
    RECIPIENT_READ_PRINT_FACILITY_SETTING_Y("RecROFac-Set-Y","Password123!"),
    RECIPIENT_READ_PRINT_FACILITY_SETTING_N("RecROFac-Set-N","Password123!"),
    //Recipe Read/Print Only + Settings - Corp Level
    RECIPIENT_READ_PRINT_CORP_SETTING_Y("RecROCorp-Set-Y","Password123!"),
    RECIPIENT_READ_PRINT_CORP_SETTING_N("RecROCorp-Set-N","Password123!"),
    //Recipe Read/Print Only + Settings - System Level
    RECIPIENT_READ_PRINT_SYS_SETTING_Y("RecROSYS-Set-Y","Password123!"),
    RECIPIENT_READ_PRINT_SYS_SETTING_N("RecROSYS-Set-N","Password123!"),
    //Recipe Read/Print Only + Settings - Database Level
    RECIPIENT_READ_PRINT_DB_SETTING_Y("RecRODataB-Set-Y","Password123!"),
    RECIPIENT_READ_PRINT_DB_SETTING_N("RecRODataB-Set-N","Password123!"),

    //Menu Full Access + Settings - Facility Level
    MENU_FULL_ACCESS_FACILITY_SETTING_Y("MenuFullFac-Set-Y","Password123!"),
    MENU_FULL_ACCESS_FACILITY_SETTING_N("MenuFullFac-Set-N","Password123!"),
    //Menu Full Access + Settings - Corp Level
    MENU_FULL_ACCESS_CORP_SETTING_Y("MenuFullCorp-Set-Y","Password123!"),
    MENU_FULL_ACCESS_CORP_SETTING_N("MenuFullCorp-Set-N","Password123!"),
    //Menu Full Access + Settings - System Level
    MENU_FULL_ACCESS_SYS_SETTING_Y("MenuFullSys-Set-Y","Password123!"),
    MENU_FULL_ACCESS_SYS_SETTING_N("MenuFullSys-Set-N","Password123!"),
    //Menu Full Access + Settings - Database Level
    MENU_FULL_ACCESS_DB_SETTING_Y("MenuFullDataB-Set-Y","Password123!"),
    MENU_FULL_ACCESS_DB_SETTING_N("MenuFullDataB-Set-N","Password123!");
    //
    private String userName;
    private String password;

    UserLevelAccount(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
