/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taf;

/**
 *
 * @author Tecra
 */
public class DevData {
    
     private String Devloppeur;
     private String jour;
     private int NbSctripts;
     
     public DevData(String Devloppeur,String jour,int NbSctripts){
         this.Devloppeur=Devloppeur;
         this.NbSctripts=NbSctripts;
         this.jour=jour;
     }

    public String getDevloppeur() {
        return Devloppeur;
    }

    public void setDevloppeur(String Devloppeur) {
        this.Devloppeur = Devloppeur;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getNbSctripts() {
        return NbSctripts;
    }

    public void setNbSctripts(int NbSctripts) {
        this.NbSctripts = NbSctripts;
    }
     
    
     @Override
    public String toString() {
        return "Dev{" + "Developpeurs: " + Devloppeur + ", jour: " + jour + ", jour=" + jour + ", NbScripts: " + NbSctripts + '}';
    }

    
}
