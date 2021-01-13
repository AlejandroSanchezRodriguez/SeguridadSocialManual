package Models.Menu;

public class Menu_Model_eng {

    String btn1_text, btn2_text, btn3_text;
    String[] btnsText;

    public Menu_Model_eng(){
        btn1_text = "Manual";
        btn2_text = "Demo";
        btn3_text = "About";
        btnsText = new String[3];
    }

    public String getBtn1_text() {
        return btn1_text;
    }

    public String getBtn2_text() {
        return btn2_text;
    }

    public String getBtn3_text() {
        return btn3_text;
    }

    public String[] getBtnsText() {
        btnsText[0] = btn1_text;
        btnsText[1] = btn2_text;
        btnsText[2] = btn3_text;
        return btnsText;
    }
}
