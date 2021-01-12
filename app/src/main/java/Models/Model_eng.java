package Models;

import java.util.ArrayList;

public class Model_eng {
    ArrayList<String> listVEnglish= new ArrayList<>();
    public Model_eng(){
        listVEnglish.add("Change Language");
        listVEnglish.add("1. Login");
        listVEnglish.add("2. Upload Files");
        listVEnglish.add("3. Rename Files");
        listVEnglish.add("4. Delete Files or Directories");
        listVEnglish.add("5. Create Directory");
        listVEnglish.add("6. Send E-mail");
        listVEnglish.add("7. Receive E-mail");
        listVEnglish.add("8. About");
    }

    public ArrayList<String> getListVEnglish() {
        return listVEnglish;
    }
}
