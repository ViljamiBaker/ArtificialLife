package artificiallife;
// stores and runs each generation of jellies
public class Generation{
   DNA[] jcdnas;
   double[] scores;
   // new gen
   public Generation(DNA[] jcdnas, double[] scores){
      this.jcdnas = jcdnas;
      this.scores = scores;
   }
   // gets the best score out of all of the jellies
   public DNA getBest(){
      int bestIndex = 0;
      double bestScore = -100000.0;
      for(int i =0; i<jcdnas.length; i++){
         if(scores[i]>bestScore){
            bestScore = scores[i];
            bestIndex = i;
         }
      }
      return jcdnas[bestIndex];
   }
   // runs a completely new generation
   static public Generation runNewGeneration(int count, int maxindex){
      DNA[] jcdnas = new DNA[count];
      double[] scores = new double[count];
      for(int i =0; i<count; i++){
         JellyCreature jc = JellyAi.genJellyCreature();
         jcdnas[i] = new DNA(jc);
         scores[i] = simCreature(jc,maxindex);
      }
      Generation gen = new Generation(jcdnas,scores);
      gen.sortDNA();
      return gen;
   }
   // runs a generation based off of the previous one
   public Generation runGeneration(int maxindex){
      scores = new double[jcdnas.length];
      for(int i =0; i<jcdnas.length; i++){
         JellyCreature jc = JellyAi.buildWithDNA(jcdnas[i]);
         scores[i] = simCreature(jc,maxindex);
      }
      sortDNA();
      return new Generation(jcdnas,scores);
   }
   // simulates a creature
   static public double simCreature(JellyCreature OG, int maxindex){
      JellyCreature jc = JellyAi.buildWithDNA(new DNA(OG));
      for(int i = 0; i<maxindex; i++){
         JellyAi.updateCreature(i,jc);
      }
      return jc.getScore();
   }
   // mutates all of the jellies and sorts them
   public void evolve(){
      double[] chances = new double[scores.length];
      double m = (-1.0)/(double)scores.length;
      for(int i = 0; i<scores.length; i++){
         chances[i] = 1+(m*(double)i);
      }
      DNA[] selected = new DNA[jcdnas.length];
      for(int i = 0; i<jcdnas.length/2; i++){
         if(Math.random()<chances[i]){
            selected[i] = jcdnas[i];
            selected[jcdnas.length-1-i] = jcdnas[i].mutate();
         }else{
            selected[i] = jcdnas[jcdnas.length-1-i];
            selected[jcdnas.length-1-i] = jcdnas[jcdnas.length-1-i].mutate();
         }
      }
      jcdnas = selected;
   }
   // sorts all of the dna from worst to best
   public void sortDNA(){
   
      boolean sort = false;
      
      while(sort == false){
      sort = true;
         for(int i = 0; i<jcdnas.length-1; i++){
            if(scores[i]<scores[i+1]){
               sort = false;
               double temp = scores[i];
               scores[i] = scores[i+1];
               scores[i+1] = temp;
               DNA tempdna = jcdnas[i];
               jcdnas[i] = jcdnas[i+1];
               jcdnas[i+1] = tempdna;
            }
         }
      }
   }
}