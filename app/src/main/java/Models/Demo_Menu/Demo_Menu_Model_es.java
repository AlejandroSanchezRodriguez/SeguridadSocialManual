package Models.Demo_Menu;

public class Demo_Menu_Model_es {

    String btn1Txt, btn2Txt, btn3Txt, btn4Txt;
    String[] values;

    public Demo_Menu_Model_es(){
        btn1Txt = "Video Login";
        btn2Txt = "Video Archivos";
        btn3Txt = "Video Email";
        btn4Txt = "Video Acerca de";
        values = new String[4];
    }

    public String getBtn1Txt() {
        return btn1Txt;
    }

    public String getBtn2Txt() {
        return btn2Txt;
    }

    public String getBtn3Txt() {
        return btn3Txt;
    }

    public String getBtn4Txt() {
        return btn4Txt;
    }

    public String[] getValues() {
        values[0] = btn1Txt;
        values[1] = btn2Txt;
        values[2] = btn3Txt;
        values[3] = btn4Txt;
        return values;
    }
}