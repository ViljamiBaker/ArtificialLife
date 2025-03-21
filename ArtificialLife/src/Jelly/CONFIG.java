package src.Jelly;
public class CONFIG{
   // TO USE CONFIG VALUES IN THE TXT FILE SET UseConfig? TO 1

   // How many generations to run
   public static int GENERATIONC = 20;
   // How long each jelly gets to run for
   public static int MAX_ITER = 1000;
   // How many jellies there are in total
   public static int CREATURES = 100;
   
   // How much each vertex of a jelly slows in the air
   public static double DRAG = 0.99;
   // How much each vertex of a jelly slows on the ground
   public static double GROUND_DRAG = 0.1;
   // How much each vertex of a jelly is pulled down
   public static double GRAVP = -0.3;
   // How high the ground is, kind useless
   public static double FLOOR_HEIGHT = 30;
   
   // How long each spring of a jelly can be
   public static double LMAX = 1.5;
   // How short each spring of a jelly can be
   public static double LMIN = 0.5;
   
   // How strong each spring of a jelly can be, numbers above 3 can be unstable
   public static double SMAX = 1.5;
   // How weak each spring of a jelly can be, numbers below like 0.2 can be unstable
   public static double SMIN = 0.5;
   
   // How long each state of a jelly can last
   public static int STATE_MAX = 200;
   // How short each state of a jelly can last
   public static int STATE_MIN = 20;
   
   // How far off a mutation can go from the current values in a jelly
   public static double MAXMUTATE = 1.0;
   // How far off a "large" mutation can go from the current values in a jelly
   public static double MAXBIGMUTATE = 20.0;
   
   // How common a mutation is, values above 1 mean 100% and below 0 mean 0%
   public static double MUTATE_CHANCE = 0.1;
   
   // How common a "large" mutation is , values above 1 mean 100% and below 0 mean 0%
   public static double BIG_MUTATE_CHANCE = 0.50;
   
   // What the jellies are scored off of, more info in SCORETYPE file
   public static SCORETYPE SCORING_CASE = SCORETYPE.XFAR;
   
   // Save only best and worst if false, otherwise save all of the jellies in the final generation
   public static boolean DUMP_FULL_DNA = false;
   
   public static void main(String[] args){
      JellyAi jai = new JellyAi();
      // how two use: uncomment jai.fullSim(); to run a simulation or
      // uncomment jai.simName("NAME OF SAVEDDNA HERE"); to playback a saved dna
      // with the current config
      jai.fullSim();
      //jai.simName("XFAR_1117_NYBRUHW^.274");
   }
}