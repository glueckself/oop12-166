import java.util.Iterator;

class Test {
    public static void main(String[] args) {
      OrderedSet<Description> oSet1 = new OrderedSet<Description>();
      Description[] desc= {new Description("1x"),
                      new Description("2xx"),
                      new Description("2xx"),
                      new Description("1x"),
                      new Description("1x"),
                      new Description("7xxxxxxx"),
                      new Description("4xxxx"),
                      new Description("10xxxxxxxxxx"),
                      new Description("6xxxxxx")};
      
      for(Description i : desc) {
          oSet1.insert(i);
      }

      int countRows = 0;
      Iterator<Description> oSet1Iterator = oSet1.iterator();
      while(oSet1Iterator.hasNext()) {
          System.out.println(oSet1Iterator.next()); //nicht für test notwendig
          countRows++;
      }
      System.out.println(countRows);


      OrderedMap<MeanElapsedTime,CompositeTime> oMap = new OrderedMap<MeanElapsedTime,CompositeTime>();
      MeanElapsedTime[] et = new MeanElapsedTime[4];
      
      for(int i = 0; i < et.length;i++) {
        et[i]=new MeanElapsedTime();
        
        for(int j = 0; j < 5; j++) {
          et[i].insert(new Double(i*j));
        }
      }

      for(MeanElapsedTime obj : et) {
        oMap.insert(obj);
      }

      
      Iterator <MeanElapsedTime> oMapI1 = oMap.iterator();

      while(oMapI1.hasNext()) {
        MeanElapsedTime testE = oMapI1.next();
        Iterator<CompositeTime> oMapInnerI1 = oMapI1.iterator();
        for(int j=10; j>5;j--) {
          Double data[] = new Double[3];
          for(int k=1; k<4;k++) {
            data[k] = new Double(k*j);
          }
          oMapInnerI1.add(new CompositeTime(data));
        }

      }


      while(oMapI1.hasNext()) {
        MeanElapsedTime testE = oMapI1.next();
        System.out.println(testE.max());
        Iterator<CompositeTime> oMapInnerI1 = testE.iterator();
        while(oMapInnerI1.hasNext()) {
          System.out.println(oMapInnerI1.next().min());
        }
      }
      
    }
}
