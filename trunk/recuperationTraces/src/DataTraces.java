

import java.util.Date;

public class DataTraces {
    private Long id;
    private String login, nom, champ1, champ2, champ3, champ4, champ5;
    
    private Date stamp;

    public DataTraces(String s) {
        System.out.println("On essaie de parser "+s);
        
        int pos0 = s.indexOf("#");
        int pos1 = s.indexOf("#", pos0+1);
        int pos2 = s.indexOf("#", pos1+1);
        int pos3 = s.indexOf("#", pos2+1);
        int pos4 = s.indexOf("#", pos3+1);
        int pos5 = s.indexOf("#", pos4+1);
        int pos6 = s.indexOf("#", pos5+1);
        int pos7 = s.indexOf("#", pos6+1);
        
        id = new Long(s.substring(0, pos0));
        login = s.substring(pos0+1, pos1);
        nom = s.substring(pos1+1, pos2);
        champ1 = s.substring(pos2+1, pos3);
        champ2 = s.substring(pos3+1, pos4);
        champ3 = s.substring(pos4+1, pos5);
        champ4 = s.substring(pos5+1, pos6);
        champ5 = s.substring(pos6+1, pos7);
        stamp = new Date(new Long(s.substring(pos7+1, s.length())));
        
    }

    public DataTraces(Long id, String login, String nom, String champ1, String champ2, String champ3, String champ4, String champ5, String texte) {
        this.id = id;
        this.login = login;
        this.nom = nom;
        this.champ1 = champ1;
        this.champ2 = champ2;
        this.champ3 = champ3;
        this.champ4 = champ4;
        this.champ5 = champ5;
        stamp = new Date();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public String getChamp1() {
        return champ1;
    }

    public void setChamp1(String champ1) {
        this.champ1 = champ1;
    }

    public String getChamp2() {
        return champ2;
    }

    public void setChamp2(String champ2) {
        this.champ2 = champ2;
    }

    public String getChamp3() {
        return champ3;
    }

    public void setChamp3(String champ3) {
        this.champ3 = champ3;
    }

    public String getChamp4() {
        return champ4;
    }

    public void setChamp4(String champ4) {
        this.champ4 = champ4;
    }

    public String getChamp5() {
        return champ5;
    }

    public void setChamp5(String champ5) {
        this.champ5 = champ5;
    }


    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }
    
    
    
}