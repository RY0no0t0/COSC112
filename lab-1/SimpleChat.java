import java.util.Scanner; 

public class SimpleChat {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String find = "size";
    
    System.out.println("Hi! What is your name?"); 
    String name = scan.nextLine();   
       
    System.out.print("It is nice to meet you, " + name + ". ");

    // YOUR ADDITIONAL PROMPTS GO HERE
    
    // First loop: running flow of conversations unless exit or shape is called
    int i = 0;
    while (i < 5) {

      // Asking questions
      Questions(i);

      String prompt = scan.nextLine();

      // Respond to exit
      if (prompt.toLowerCase().contains("exit")){
        System.out.println("Okay! It was fun talking to you!");
        System.exit(1);
      }

      // Check whether the user calls for a graphic
      else if (prompt.toLowerCase().contains("square") || prompt.toLowerCase().contains("triangle") || prompt.toLowerCase().contains("tree")) {
        String[] words = prompt.split("\\W+");

        // Find where "size" is
        int loc = -1;
        for (int j=0; j<words.length; j++) {
          if (words[j].equals(find)) {
            loc = j;
            break;
          }
        }

        // If "size" not found, stop the process
        if (loc==-1) {
          System.out.print("Please enter \"size\" followed by a number to draw the figure. ");
          break;
        }

        // Make sure that the word after "size" is a number. If not, stop.
        try {
          Integer.parseInt(words[loc+1]);
        } catch (Exception e) {
          System.out.print("please put the size number right after the word \"size.\" ");
          break;
        }

        int num = Integer.parseInt(words[loc+1]);

        // Draw the graphic
        Draw(prompt.toLowerCase(), num);

        // Once graphic pattern is called, conversation stops.
        break;
      }

      // If the response is not graphic or exit, take it as a response to the question.
      else {
        Response(prompt, i);
      }

      i++;
    }

    // Set the list of prompts
    String[] prompts = new String[] {"mood", "today", "sports", "music", "book"};

    // Create a loop for conversation. The user can pick what they want to talk about.
    while (true) {
      System.out.println("What do you want to talk about now?");

      String want = scan.nextLine();

      // Response to exit
      if (want.toLowerCase().contains("exit")){
        System.out.println("Okay! It was fun talking to you!");
        System.exit(1);
      }

      // Response to the graphic (details explained above). However, it doesn't break the loop this time if input is invalid.
      else if (want.toLowerCase().contains("square") || want.toLowerCase().contains("triangle") || want.toLowerCase().contains("tree")) {
        String[] words = want.split("\\W+");

        int loc = -1;
        for (int j=0; j<words.length; j++) {
          if (words[j].equals(find)) {
            loc = j;
            break;
          }
        }

        int o = 0;

        if (loc==-1) {
          System.out.print("Please enter \"size\" followed by a number to draw the figure. ");
          o++;
        }

        if (o==0) {
          int m = 0;

          try {
            Integer.parseInt(words[loc+1]);
          } catch (Exception e) {
            System.out.print("please put the size number right after the word \"size.\" ");
            m++;
          }

          if (m==0){

            int num = Integer.parseInt(words[loc+1]);

            Draw(want.toLowerCase(), num);
          }
        }
      }

      // The other response is taken as a prompt idea
      else {
        int k = 0;

        // Check if it is a valid prompt
        while (k < prompts.length){
          if (want.toLowerCase().contains(prompts[k])) {
            break;
          }

          k++;
        }

        // Ask again if it is not one of the prompts
        if (k==prompts.length) {
          System.out.print("Please pick a converation prompt from the following list:");
          for(int l = 0; l < prompts.length; l++) {
            System.out.print(" " + prompts[l]);
          }
          System.out.print(". Type \"exit\" to stop the program. ");
        }

        // If the prompt is valid, begin the conversation.
        else {
          System.out.print("Cool!");
          Questions(k);
          String prompt = scan.nextLine();
          
          // Response to exit
          if (prompt.toLowerCase().contains("exit")){
            System.out.println("Okay! It was fun talking to you!");
            System.exit(1);
          }

          // Response to graphic
          else if (prompt.toLowerCase().contains("square") || prompt.toLowerCase().contains("triangle") || prompt.toLowerCase().contains("tree")) {
            String[] words = prompt.split("\\W+");
    
            int loc = -1;
            for (int j=0; j<words.length; j++) {
              if (words[j].equals(find)) {
                loc = j;
                break;
              }
            }
    
            int o = 0;
    
            if (loc==-1) {
              System.out.print("Please enter \"size\" followed by a number to draw the figure. ");
              o++;
            }
    
            if (o==0) {
              int m = 0;
    
              try {
                Integer.parseInt(words[loc+1]);
              } catch (Exception e) {
                System.out.print("please put the size number right after the word \"size.\" ");
                m++;
              }
    
              if (m==0){
    
                int num = Integer.parseInt(words[loc+1]);
    
                Draw(prompt.toLowerCase(), num);
              }
            }
          }

          // Otherwise, it is a response to the question of the prompt
          else {
            Response(prompt, k);
          }
        }
      }
    }
  }

  // Set of questions for prompts. Can be called by a number.
  public static void Questions (int number) {
    if (number==0) {
      System.out.println("How are you doing today?");
    }

    else if (number==1) {
      System.out.println("What did you do today?");
    }

    else if (number==2) {
      System.out.println("What sports do you like?");
    }

    else if (number==3) {
      System.out.println("What genre of music do you like?");
    }

    else if (number==4) {
      System.out.println("What genre of books do you like?");
    }

    else {
      System.out.println("Unexpected prompt number. Quit the system.");
      System.exit(1);
    }
  }

  // Set of responses to the user's answer. Can be called by a number same as Questions().
  public static void Response (String response, int numb) {
    if (numb==0) {
      MoodConv(response);
    }

    else if (numb==1) {
      TodayConv(response);
    }

    else if (numb==2) {
      SportsConv(response);
    }

    else if (numb==3) {
      MusicConv(response);
    }

    else if (numb==4) {
      BookConv(response);
    }
  }

  // Responses for "How are you?"
  public static void MoodConv (String mood) {

    if (mood.toLowerCase().contains("good")) {
      System.out.print("That's amazing! ");
    }

    else if (mood.toLowerCase().contains("fine")){
      System.out.print("Your day will be better soon! ");
    }

    else if (mood.toLowerCase().contains("bad")){
      System.out.print("I cursed you so that you have a good day today! ");
    }

    else {
      System.out.print("I am sorry. I don't know any words other than good, fine or bad :( Anyway, ");
    }
    
  }

  // Responses for "What did you do today?"
  public static void TodayConv (String today) {

    if (today.toLowerCase().contains("study") || today.toLowerCase().contains("studied")) {
      System.out.print("Good work! You deserve a break :) ");
    }

    else if (today.toLowerCase().contains("nap")){
      System.out.print("Napping is always the best! ");
    }

    else if (today.toLowerCase().contains("go") || today.toLowerCase().contains("went")){
      System.out.print("I hope that was fun! ");
    }

    else {
      System.out.print("I didn't know you can spend a day other than study, nap, or going out! ");
    }
    
  }

  // Responses for "What sports do you like?"
  public static void SportsConv (String sports) {

    if (sports.toLowerCase().contains("baseball")) {
      System.out.print("Oh, I love baseball, too! I love Ohtani. ");
    }

    else if (sports.toLowerCase().contains("soccer")){
      System.out.print("I used to play soccer every week! ");
    }

    else if (sports.toLowerCase().contains("basketball")){
      System.out.print("I cannot throw that heavy ball. ");
    }

    else {
      System.out.print("I don't know that sport! Tell me about it later :) ");
    }
    
  }

  // Responses for "What genre of music do you like?"
  public static void MusicConv (String music) {

    if (music.toLowerCase().contains("classic")) {
      System.out.print("Classical music is underrated... I love Dvorak! ");
    }

    else if (music.toLowerCase().contains("jazz")){
      System.out.print("The passion in jazz is cool! I love Cliford Brown. ");
    }

    else if (music.toLowerCase().contains("pop")){
      System.out.print("Pop music is always fun! I listen to J-pop. ");
    }

    else {
      System.out.print("I need to listen more genres other than classic, jazz, or pop! ");
    }
    
  }

  // Responses for "What genre of books do you like?"
  public static void BookConv (String book) {

    if (book.toLowerCase().contains("mystery")) {
      System.out.print("I used to read mystery so much! I love Arsene Lupin. ");
    }

    else if (book.toLowerCase().contains("sci-fi")){
      System.out.print("I love sci-fi too! \"Ready Player One\" is definitely one of my favorite books! ");
    }

    else if (book.toLowerCase().contains("fantasy")){
      System.out.print("I read fantasy, a lot, too! \"Yatagarasu\" series is my favorite, but I think it's only in Japanese... ");
    }

    else {
      System.out.print("I haven't really explored that genre, yet! Give me a recommendation someday! ");
    };
    
  }

  // Drawing the graphics. 
  public static void Draw (String shape, int size) {
    
    System.out.println("Here we go!");

    // For square
    if (shape.contains("square")) {
      for (int p=0; p < size; p++) {
        if (p==0 || p == size-1) {
          for (int q=0; q < size; q++) {
            if (q == size-1){
              System.out.println("+");
            }
            else {
              System.out.print("+");
            }
          }
        }
        else {
          for (int r=0; r < size; r++) {
            if (r == 0) {
              System.out.print("+");
            }
            else if (r == size-1) {
              System.out.println("+");
            }
            else {
              System.out.print(" ");
            }
          }
        }
      }
    }

    // For Triangle
    else if (shape.contains("triangle")) {
      for (int p = 0; p < size; p++) {
        if (p == size-1) {
          for (int q=0; q < size; q++) {
            if (q == size-1){
              System.out.println("+");
            }
            else {
              System.out.print("+");
            }
          }
        }
        else {
          for (int r = 0; r < p+1; r++) {
            if (r == p) {
              System.out.println("+");
            }
            else if (r==0) {
              System.out.print("+");
            }
            else {
              System.out.print(" ");
            }
          }
        }
      }
    }

    // For Tree
    else if (shape.contains("tree")) {
      for (int p=0; p < size; p++) {
        for (int q = 0; q < size+p;q++){
          if (q == size+p-1) {
            System.out.println("+");
          }
          else if (q < size-p-1) {
            System.out.print(" ");
          }
          else {
            System.out.print("+");
          }
        }
      }
      for (int r = 0; r < size; r++) {
        if (r == size-1) {
          System.out.println("|");
        }
        else {
          System.out.print(" ");
        }
      }
    }
  }

} // class SimpleChat

