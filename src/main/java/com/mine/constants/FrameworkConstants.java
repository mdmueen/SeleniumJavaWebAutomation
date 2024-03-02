package com.mine.constants;

public final class FrameworkConstants { // making the class as final because dont want other classes like testcases classes to extend this, because testcases classes should extend only BaseTest class

    private FrameworkConstants() { } // making the constructor as private, because dont want other classes to create object for this class to access its data & methods which they can directly access as they are declared as static

    private static final String CHROMEDRIVERPATH = "";

    public static String getCHROMEDRIVERPATH() {
        return CHROMEDRIVERPATH;
    }
}
