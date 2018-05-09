import org.w3c.dom.Text;

/**
 * Created by Niko on 9.3.2018..
 */

public class monsteri {
    private String Name;
    private String Type;
    private String Size;
    private String Alignment;
    private String Tag;
    private int AC;
    private int HP;
    private int HitDice;
    private int HitSize;
    private int Adjustment;
    private float CR;
    private int EXP;
    private int CasterLvl;
    private String CasterType;
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;
    private int Speed_Base;
    private int Speed_Burrow;
    private int Speed_Climb;
    private int Speed_Fly;
    private int Speed_Swim;
    private int STR_Saving;
    private int DEX_Saving;
    private int CON_Saving;
    private int INT_Saving;
    private int WIS_Saving;
    private int CHA_Saving;
    private Text Resistances;
    private Text Perks;
    private Text Senses;
    private String Languages;
    private Text Attacks;
    private int Shapeshifter;


    public monsteri()
    {
    }
    public monsteri(String Name,String Type,String Size,String Alignment,String Tag,int AC,int HP,int HitDice,int HitSize,int Adjustment,float CR,int EXP,int CasterLvl,String CasterType,int STR,int DEX,int CON,int INT,int WIS,int CHA,int Speed_Base,int Speed_Burrow,int Speed_Climb,int Speed_Fly,int Speed_Swim,int STR_Saving,int DEX_Saving,int CON_Saving,int INT_Saving,int WIS_Saving,int CHA_Saving,Text Resistances,Text Perks,Text Senses,String Languages,Text Attacks,int Shapeshifter)
    {
        this.Name=Name;
        this.Type=Type;
        this.Size=Size;
        this.Alignment=Alignment;
        this.Tag=Tag;
        this.AC=AC;
        this.HP=HP;
        this.HitDice=HitDice;
        this.HitSize=HitSize;
        this.Adjustment=Adjustment;
        this.CR=CR;
        this.EXP=EXP;
        this.CasterLvl=CasterLvl;
        this.CasterType=CasterType;
        this.STR=STR;
        this.DEX=DEX;
        this.CON=CON;
        this.INT=INT;
        this.WIS=WIS;
        this.CHA=CHA;
        this.Speed_Base=Speed_Base;
        this.Speed_Burrow=Speed_Burrow;
        this.Speed_Climb=Speed_Climb;
        this.Speed_Fly=Speed_Fly;
        this.Speed_Swim=Speed_Swim;
        this.STR_Saving=STR_Saving;
        this.DEX_Saving=DEX_Saving;
        this.CON_Saving=CON_Saving;
        this.INT_Saving=INT_Saving;
        this.WIS_Saving=WIS_Saving;
        this.CHA_Saving=CHA_Saving;
        this.Resistances=Resistances;
        this.Perks=Perks;
        this.Senses=Senses;
        this.Languages=Languages;
        this.Attacks=Attacks;
        this.Shapeshifter=Shapeshifter;

    }

    /* SET metode*/
    public void setName(String Name) {
        this.Name=Name;
    }
    public void setType(String Type) {
        this.Type = Type;
    }
    public void setSize(String Size) {
        this.Size = Size;
    }
    public void setAlignment(String Alignment) {
        this.Alignment = Alignment;
    }
    public void setTag(String Tag) {
        this.Tag = Tag;
    }
    public void setAC(int AC){this.AC=AC;}
    public void setHP(int HP){this.HP=HP;}
    public void setHitDice(int HitDice){this.HitDice=HitDice;}
    public void setHitSize(int HitSize){this.HitDice=HitSize;}
    public void setAdjustment(int Adjustment){this.Adjustment=Adjustment;}
    public void setCR(float CR){this.CR=CR;}
    public void setEXP(int EXP){this.EXP=EXP;}
    public void setCasterLvl(int CasterLvl){this.CasterLvl=CasterLvl;}
    public void setCasterType(String CasterType){this.CasterType=CasterType;}
    public void setSTR(int STR){this.STR=STR;}
    public void setDEX(int DEX){this.DEX=DEX;}
    public void setCON(int CON){this.CON=CON;}
    public void setINT(int INT){this.INT=INT;}
    public void setWIS(int WIS){this.WIS=WIS;}
    public void setCHA(int CHA){this.CHA=CHA;}
    public void setSpeed_Base(int Speed_Base){this.Speed_Base=Speed_Base;}
    public void setSpeed_Burrow(int Speed_Burrow){this.Speed_Burrow=Speed_Burrow;}
    public void setSpeed_Climb(int Speed_Climb){this.Speed_Climb=Speed_Climb;}
    public void setSpeed_Fly(int Speed_Fly){this.Speed_Fly=Speed_Fly;}
    public void setSpeed_Swim(int Speed_Swim){this.Speed_Swim=Speed_Swim;}
    public void setSTR_Saving(int STR_Saving){this.STR_Saving=STR_Saving;}
    public void setDEX_Saving(int DEX_Saving){this.DEX_Saving=DEX_Saving;}
    public void setCON_Saving(int CON_Saving){this.CON_Saving=CON_Saving;}
    public void setINT_Saving(int INT_Saving){this.INT_Saving=INT_Saving;}
    public void setWIS_Saving(int WIS_Saving){this.WIS_Saving=WIS_Saving;}
    public void setCHA_0Saving(int CHA_Saving){this.CHA_Saving=CHA_Saving;}
    public void setResistances(Text Resistances){this.Resistances=Resistances;}
    public void setPerks(Text Perks){this.Perks=Perks;}
    public void setSenses(Text Senses){this.Senses=Senses;}
    public void setLanguages(String Languages){this.Languages=Languages;}
    public void setAttacks(Text Attacks){this.Attacks=Attacks;}
    public void setShapeshifter(int Shapeshifter){this.Shapeshifter=Shapeshifter;}




    /* GET METODE*/
    public String getName() {
        return Name;
    }
    public String getType() {
        return Type;
    }
    public String getSize() {
        return Size;
    }
    public String getAlignment() {
        return Alignment;
    }
    public String getTag() {
        return Tag;
    }
    public int getAC(){return AC;}
    public int getHP(){return HP;}
    public int getHitDice(){return HitDice;}
    public int getHitSize(){return HitSize;}
    public int getAdjustment(){return Adjustment;}
    public float getCR(){return CR;}
    public int getEXP(){return EXP;}
    public int getCasterLvl(){return CasterLvl;}
    public String getCasterType(){return CasterType;}
    public int getSTR(){return STR;}
    public int getDEX(){return DEX;}
    public int getCON(){return CON;}
    public int getINT(){return INT;}
    public int getWIS(){return WIS;}
    public int getCHA(){return CHA;}
    public int getSpeed_Base(){return Speed_Base;}
    public int getSpeed_Burrow(){return Speed_Burrow;}
    public int getSpeed_Climb(){return Speed_Climb;}
    public int getSpeed_Fly(){return Speed_Fly;}
    public int getSpeed_Swim(){return Speed_Swim;}
    public int getSTR_Saving(){return STR_Saving;}
    public int getDEX_Saving(){return DEX_Saving;}
    public int getCON_Saving(){return CON_Saving;}
    public int getINT_Saving(){return INT_Saving;}
    public int getWIS_Saving(){return WIS_Saving;}
    public int getCHA_Saving(){return CHA_Saving;}
    public Text getResistances(){return Resistances;}
    public Text getPerks(){return Perks;}
    public Text getSenses(){return Senses;}
    public String getLanguages(){return Languages;}
    public Text getAttacks(){return Attacks;}
    public int getShapeshifter(){return Shapeshifter;}
}
