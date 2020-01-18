package com.dev.ep.employeeportal.model;

public enum Designation {

    SOFTWARE_ENGINEER("SOFTWARE ENGINEER"), ANALYST("ANALYST"),
    ARCHITECT("ARCHITECT"), SENIOR_ARCHITECT("SENIOR ARCHITECT"),
    PRINCIPAL_ARCHITECT("PRINCIPAL ARCHITECT"), MANAGER("MANAGER"),
    SENIOR_MANAGER("SENIOR MANAGER"), PRINCIPAL("PRINCIPAL"),
    VICE_PRESIDENT("VICE PRESIDENT"), PRESIDENT("PRESIDENT"), CEO("CEO");

    private String label;

    private Designation(String label) {
        this.label = label;
    }

    public static Designation findByLabel(String byLabel) {
        for (Designation d : Designation.values()) {
            if (d.label.equalsIgnoreCase(byLabel))
                return d;
        }
        return null;
    }
}
