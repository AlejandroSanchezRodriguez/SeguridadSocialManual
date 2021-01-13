package Models;

import java.util.ArrayList;

public class Model_eng {
    ArrayList<String> listVEnglish;
    public Model_eng(){
        listVEnglish= new ArrayList<>();
        listVEnglish.add("Change Language");
        listVEnglish.add("1. Login");
        listVEnglish.add("2. Options Menu");
        listVEnglish.add("3. Upload Files");
        listVEnglish.add("4. Rename Files");
        listVEnglish.add("5. Delete Files or Directories");
        listVEnglish.add("6. Create Directory");
        listVEnglish.add("7. Send E-mail");
        listVEnglish.add("8. Receive E-mail");
        listVEnglish.add("9. About");
    }

    public ArrayList<String> getListVEnglish() {
        return listVEnglish;
    }
}
