
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Hw1Final481;
import static spark.Spark.get;
  import static spark.Spark.port;
  import static spark.Spark.post;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.Map;

  import spark.ModelAndView;
  import spark.template.mustache.MustacheTemplateEngine;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

      public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World 2");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));


          String input1 = req.queryParams("input1").replaceAll("\\s","");
          int input1AsInt = Integer.parseInt(input1);

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);


          String input4 = req.queryParams("input4");
          java.util.Scanner sc1 = new java.util.Scanner(input4);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          sc1.close();
          System.out.println(inputList);

          boolean result = App.isValid_WhatType_And_isLargeEnough(input1AsInt,input2AsInt,input3AsInt,inputList);

          Map<String, Boolean> map = new HashMap<String, Boolean>();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map<String, String> map = new HashMap<String, String>();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    
    public static boolean isValid_WhatType_And_isLargeEnough(int a,int b,int c,ArrayList<Integer> circumfrences){

        //STEP1: Check if the given sides is feasible. This means a side cannot be <=0

        if(a<=0 || b<=0 || c<=0){
          System.out.println("A given side cannot be equal or smaller than zero.");
            System.out.println("");
          return false;  
        }

        //STEP2: Check if the array is empty

        if(circumfrences.size()==0){
            System.out.println("Given circumfrences array is empty.");
            System.out.println("");
            return false;
        } 

        //STEP3: Check if a triangle can be made with sides, a b and c using mathematical definition of a triangle
       
        int count=0;
        if(!(a>Math.abs(b-c) && a<(b+c))){
            count=1;
        }
        if(!(b>Math.abs(a-c) && b<(a+c))){
            count=1;
        }
        if(!(c>Math.abs(b-a) && c<(b+a))){
            count=1;
        }
        if(count==1){
            System.out.println("A triangle cannot be formed with given sides.");
            System.out.println("");
            return false;
        }
        else{
            count=0;
            System.out.println("A triangle can be formed with given sides.");
            //finding what type of triangle it is
            if(a==b){
                count++;
            }
            if(a==c){
                count++;
            }
            if(b==c){
                count++;
            }
            if(count==3){
                System.out.println("The triangle formed is a equilateral triangle.");
            }
            else{
                if(count==0){
                    System.out.println("The triangle formed is a isoscele striangle.");

                }
                else
                System.out.println("The triangle formed is a scalene triangle.");
            }
            count=0;
            //now lets find if it is large enough by comparing to the circumfrence needs in our circumfrence array.
            int mainCircumfrence=a+b+c;
            for(int i=0;i<circumfrences.size();i++){
                if(circumfrences.get(i)>mainCircumfrence){
                    System.out.println("The triangle formed is NOT large enough to satisfy the needs.");
                    System.out.println("");
                    return false;
                }
            }
            System.out.println("The triangle formed is large enough to satisfy the needs.");
            System.out.println("");
            return true;
        }

    }

}



