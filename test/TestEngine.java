import game.GamePanel;
import game.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestEngine {
    // Fields
    final static int FPS = 30;
    final static int SCREEN_WIDTH = 1920/2;
    final static int SCREEN_HEIGHT = 1080/2;
    static Thread thread = new Thread();
    static int currentIndex = 0;
    static TextField msgBox = new TextField(32);
    static JPanel panel = new JPanel();
    static JFrame window = new JFrame();
    static String[] rappers = { "GuiseppeBigGains",
        "BloodBoyScrump",
        "BigMud",
        "MGGirth",
        "YungSlime",
        "SmokeJesus",
        "SloopJohn",
        "RichBiggums",
        "Rawdog",
        "LilSchnieder",
        "44DungBeetle",
        "TwistyFresha",
        "LeatherBoiWide",
        "DaPimp",
        "NGFLongBoi",
        "LilBeano",
        "BrokeBoyDogBreath",
        "LiterallyJohnMulaney",
        "PooStanky",
        "ChicagoGlizzy",
        "IcedOutFaceTattz",
        "LilWatanabe",
        "4Whayyyt",
        "LilRodney",
        "LilTravis",
        "JuicyMelly",
        "OMSTater",
        "SYGJawbreaker",
        "HarverdPhD",
        "DrankKetchup",
        "WideSnake",
        "JesusFoSho",
        "Str8Cheekz",
        "YungApplesauce",
        "LilClinton",
        "LilHitter",
        "SleazFromDa610",
        "SlippyTenacious",
        "DrPurp",
        "GoopViolence",
        "BustaSlyme",
        "TroubleShoota",
        "BonusDart",
        "SkinnyGucci",
        "HoopGod",
        "BMInkontinent",
        "SDeezy",
        "MadRelly",
        "HomeboyHenny",
        "SlyDevious",
        "NosFuturo",
        "ASAPClarence",
        "FuegoBattery",
        "RolexGMT",
        "7evenFitty",
        "YoungCanada",
        "FatGod",
        "SlickBoiMikey",
        "HotDaniel",
        "JuiceFromDa9",
        "GrippaT",
        "LilGasCar",
        "QuanTheYoungGod",
        "RichBoyWaterslide",
        "ChiefFlavor",
        "MessyBrown",
        "SMPSimpleton",
        "GroovyNardo",
        "BadVibesMoney",
        "LilSkeeter",
        "ScooterMadHustle",
        "VroomGodLaCroix",
        "OGSeltzerWater",
        "VroWitDa9",
        "Pump12",
        "CloutFinesser",
        "NastyGodGordo",
        "YungPortabella",
        "GreazyScrum",
        "NarcoDrip",
        "BrokeBoyGimmeCash",
        "DollaSignDonkey",
        "FreshOutADAT",
        "YungExistentialEnnui",
        "DubD40",
        "Katch22",
        "GorillaFingas",
        "GruntSolid",
        "HotSnakez",
        "JuiceBox",
        "LoudBoySwangin",
        "LilTonyDanza",
        "SideShowMafia",
        "SlightDeuce",
        "AcesMcLuvin",
        "BrownSerpent",
        "AshrafAliG",
        "StraightGrippin",
        "HuffaJohnson",
        "NGFRock",
        "RickyBussin",
        "BigMoneyRaxx",
        "MuleJunkie",
        "DetroitDawgDante",
        "LilMissileLauncher",
        "ConstipatedGod",
        "SlippinJesus",
        "PushaTurd",
        "FatBoiSoiledIt",
        "PumpinLemma",
        "TheGangFooTracy",
        "RacyLambo",
        "SlickBoiMushy",
        "OsbourneTheRich",
        "GondolaWide",
        "GunnaFart",
        "LarryStraightGoopin",
        "KleenexTheGoon",
        "SplezTheSlimeGod",
        "Slapbox",
        "YungLaxative",
        "DoubleFlusha",
        "TI84+GC",
        "ChildrensBenadrylTheLimited",
        "GSkramz",
        "HatManRocky",
        "MumblerBusta",
        "LilWhispas",
        "ChillBoiLilFeet",
        "29Ampin",
        "TopBoyAthletesFoot",
        "KidPituitary",
        "ShortBoiDoubleShot",
        "MBHCoffeeRuns",
        "HersheySquirtz",
        "CowPieFromTheBlock",
        "JuanTo3for5",
        "OGButterup",
        "QuesoFlava",
        "PoorMeatHead",
        "JuiceReppin",
        "FacistMarx",
        "LilSqueej",
        "BigStinky",
        "AlvinFromTheGroup",
        "BabyJimmyLegs",
        "TheKidMilk",
        "SmoothMoveFerguson",
        "JBSelfPortrait",
        "BankHobo",
        "SherfDollaSign",
        "BeefDriver",
        "PostStamp",
        "OnDaProtein",
        "TrapBoiSkinner",
        "CorpulentFlexa",
        "MoneyBandzPablo",
        "TrayvonTheSquirrel",
        "IceManGnarly",
        "CripKidOnion",
        "BassKnocker",
        "SkinnyBoiHeavy",
        "SlickRationale",
        "LilSinner",
        "DeltaThickumz",
        "RayRayPlaster",
        "JalenScrumptious",
        "YungDefecation",
        "DoubleCupDrippin",
        "EdgeLordFuneral",
        "DaHandOfManny",
        "FlexGodBleach",
        "HoodBoyDappy",
        "Out4Blood",
        "TimmyDaGrippa",
        "BrokeBoyLester",
        "OrneryGod",
        "HittinJuvie",
        "ShortBusRyder",
        "VrodieCrimpin",
        "FamousGordon",
        "PlayboyWalkout",
        "TrippyPimp",
        "FlatheadTheRapper",
        "KBoyWasted",
        "MLKSquid",
        "GuanoLegendary",
        "MilkLustKing",
        "HashBrownDaMeek",
        "347Dinky",
        "PooMask",
        "BigToeSwangin",
        "FaceGrillStrappin",
        "MusclePumpa",
        "NGFZootopia",
        "StankyGodBenson",
        "LilWagon",
        "DreadlockMafia",
        "OMSPoignant",
        "DripJesus",
        "KrumpLumpin",
        "MessyWC",
        "GloopGoonin",
        "FatNasty",
        "SlickMikey",
        "MadFunky",
        "SLPCoppa",
        "LotionDaddy",
        "LooseBoiWild",
        "NarcoBrackets",
        "BigTurdPushin",
        "ScrumpNoCap",
        "NeckFlexin",
        "BigJesus",
        "Str8Flamez",
        "LilArson",
        "YungLarceny",
        "PaperGrippin",
        "KombuchaTheKing",
        "JerryOnGang",
        "TrippyBalla",
        "DollaSignRascal",
        "TimeOutDougie",
        "StinkyPloppa",
        "GodNeckTheUgly",
        "GuapoTrappin",
        "FreakShowTay",
        "LilFlexa",
        "LumpPumpin",
        "JumpShotLegendary",
        "BigHeresySchism",
        "LargeBandsTheGangsta",
        "GangGangBoiYeek",
        "ChimneyRatRayRay",
        "ScumGodSlick",
        "SewerBoiCankles"
        };

    public static void main(String[] args) {

      //Test suite for the engine
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("Fuck ass chode dick cum fart anus wiener cock turd shit queef");


      KeyListener keyHandler = new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {
          }

          @Override
          public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code){
                case KeyEvent.VK_E:
                    nextMessage();
                case KeyEvent.VK_Q:
                    previousMessage();
            }
          }
          @Override
          public void keyReleased(KeyEvent e) {
          }
      };



      panel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
      panel.setBackground(Color.BLACK);
      panel.setDoubleBuffered(true);
      panel.addKeyListener(keyHandler);
      panel.setFocusable(true);
      window.add(msgBox);
      window.add(panel);

  }
  public static void nextMessage(){
        currentIndex++;
        draw();
  }
  public static void previousMessage(){
        currentIndex = currentIndex == 0 ? rappers.length - 1 : currentIndex--;
        draw();
  }
  public static void draw(){
        msgBox.setText(rappers[currentIndex]);
        panel.repaint();
  }
}
