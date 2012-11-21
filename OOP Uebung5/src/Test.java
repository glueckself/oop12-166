import java.util.Iterator;

class Test {
    public static void main(String[] args) {
      int countRows = 0;
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

      Iterator<Description> oSet1Iterator = oSet1.iterator();

      while(oSet1Iterator.hasNext()) {
          System.out.println(oSet1Iterator.next()); //nicht für test notwendig
          countRows++;
      }

      if(countRows == desc.length) {
	  System.out.println(countRows);
	  System.out.println("Test successfull");
      } else {
	  System.out.println("Test unsuccessfull");
      }

      countRows = 0;

      for(Description i : desc) {
          oSet1.insert(i);
      }

      oSet1Iterator = oSet1.iterator();

      while(oSet1Iterator.hasNext()) {
          System.out.println(oSet1Iterator.next()); //nicht für test notwendig
          countRows++;
      }

      //same elements should not be inserted, so count should stay the same
      if(countRows == desc.length) {
	  System.out.println(countRows);
	  System.out.println("Test successfull");
      } else {
	  System.out.println("Test unsuccessfull");
      }

      //OrderedSet<ElapsedTime> tests
      OrderedSet<ElapsedTime> oSet2 = new OrderedSet<ElapsedTime>();
      MeanElapsedTime mean = new MeanElapsedTime();
      mean.insert(0.1);
      oSet2.insert(mean);
      Double[] data = {0.1,0.2};
      CompositeTime comp = new CompositeTime(data);
      oSet2.insert(comp);

      Iterator<ElapsedTime> oSet2Iterator = oSet2.iterator();

      while(oSet2Iterator.hasNext()) {
	  System.out.println(oSet2Iterator.next().count());
      }

      
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

      
      OuterIterator<MeanElapsedTime,CompositeTime> oMapI1 = oMap.iterator();

      while(oMapI1.hasNext()) {
        System.out.println(oMapI1.next().max());
      }

      oMapI1 = oMap.iterator();

      while(oMapI1.hasNext()) {
        InnerIterator<CompositeTime> oMapInnerI1 = oMapI1.iterator();
        for(int j=10; j>5;j--) {
          Double dataOD[] = new Double[3];
          for(int k=1; k<4;k++) {
            data[k-1] = new Double(k*j);
          }
          oMapInnerI1.add(new CompositeTime(dataOD));
        }

      }


      oMapI1 = oMap.iterator();
      while(oMapI1.hasNext()) {
        MeanElapsedTime testE = oMapI1.next();
        System.out.println(testE.max());
        InnerIterator<CompositeTime> oMapInnerI1 = oMapI1.iterator();
        while(oMapInnerI1.hasNext()) {
          System.out.println(oMapInnerI1.next().min());
        }
      }
      
      
    }
}
