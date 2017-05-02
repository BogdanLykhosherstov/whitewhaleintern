# Intern challenge for White Whale

**Code Challenge: Gibberish Algorithm**
---------------------------------------

Challenge Overview
------------------

We are exticed taht you are intsereted in joiinng Wihte Wahle for the smumer.  Weoclme to yuor fsrit prommarging chanellge.  Yuor chnellage is to courtsnct a prrgoam taht tekas an Enilgsh txet snirtg as iupnt and rerutns rebadale giirebbsh lkie tihs.  It dseno’t mtaetr in waht oerdr the ltteres in a wrod are, but an iproamtnt tihng is taht the frsit and lsat ltteer be in the rghit pclae. The rset can be a taotl mses and you can sitll raed it whotuit a pboerlm.  Tihs is bcuseae the huamn mnid deos not raed ervey lteter by istlef, but the wrod as a wlohe.

**The Basics:**
  
  - You may use *almost any* programming language... it's your choice.  See the supported options [here](http://ideone.com/).
  - Your program should leave the first and last letter of each word in place and scramble the rest.
  - Your program should not scamble punctuation (.,-'...etc.), numbers, or upper-case abbreviations.
  - See the [/text_files] folder for sample text files. 

**Input/Output:**
 
  - Name your program as follows: `gibgen.xx` (where xx is variable based on the language you choose)
  - Your program should be able to read text input from a string passed into STDIN
      - `gibgen.xx "This is a String"`
      - `cat mystringfile.txt | gibgen.xx`
  - Your program should output to the console.

_Note: This challenge is based on a popular word gibberish meme. You can improve the readability by looking at a [researcher's take](http://www.mrc-cbu.cam.ac.uk/people/matt.davis/cmabridge/) on the truths/myths of this meme, but this is not required._

What to do
----------
1. [Download](http://git-scm.com/downloads) & install Git on your machine

2. <a href="https://github.com/trentgillham/whitewhaleintern#fork-destination-box" class="btn grouped" data-method="POST" rel="nofollow" title="Fork">Fork</a> this project - Go [here](https://github.com/trentgillham/whitewhaleintern) and click the "Fork" button (located on the upper-right side of the screen)

2. Clone your new fork'd repository to your local machine - `git clone https://github.com/trentgillham/whitewhaleintern.git`
3. Complete the code challenge and fill out the Quick Start & Questions in the the README (see below)
4. `git add` and `git commit` your local repository as you go
4. Push your code and README back to Github occasionally - `git push origin master`
5. Email [gillham@whitewhaleanalytics.com](mailto:gillham@whitewhaleanalytics.com) with the Commit URL to your fork'd repository that you want reviewed. It should include at least 2 files: (1) your updated README with Coding Questions answered, and (2) your program (gibgen.xx)
   - Copy and paste the URL into the email along with your name... it should look something like this:
       - https://github.com/YOUR_USERNAME_HERE/whitewhaleintern.git

_Note: If you have any questions, email [gillham@whitewhaleanalytics.com](mailto:gillham@whitewhaleanalytics.com)._

Judging Criteria
----------------

Your responses to the **Coding Questions** at the bottom of this README are the *Most Important* part of this challenge. A working, fully fault-tolerant program that we just can't break, albeit awesome, is the least important.  Why is that?  Remember, we don't expect you to be expert programmers (just yet)... We want to see how you think through a problem.  


For completion by applicant
===========================

Quick Start
-----------

* Run java gibgen "String name" -  to work with a string. Run java gibgen "text.txt" - to read from a file. Its important its name is text.txt.
* I used Java - more on it in the coding questions.



Coding Questions
----------------

Question 1: "How did you approach the problem?" (500 words or less)

Answer: First and foremost I have started with considering which language I would use. I have decided to use java due to a variety of different libraries it has available and because I am most familiar with it. Then I have divided my task into 3 phases: Planning, Coding, Testing and debugging. 

Planning: It seemed like a fairly trivial algorithm at first, however, upon further looking into it I started wondering how to deal with punctuation and spaces between words and how to account for an array of different characters that will appear between seperate words. The approach I've gone with was to shuffle one word at a time and put a punctuation right after each one. This way, my algorithm would only have to deal with alphabetic characters and apostrophies only. After getting a general idea for my solution I've delved into the coding phase. I've also ensured to only shuffle the characters between the first and the last index since those letters have to be untouched.

Coding: I've created 2 arrays to store all words and punctuations. Using string splitting I was able to seperate the two easily and begin my shuffling algorithm for each individual word. For said algorithm, instead of using a Math.random, I've figured I could do something different that would give the impression of randomness without actually being random. I've decided to switch the index of even characters with odd(i=1 with i=2, i=3 with i=4, etc). To accomplish this, I've scanned through the entire word (except for the first and last letter), adding each odd and even indexed character to a corresponding, seperate que. Then, I would alternate between appending to the new string with a first character of the original word from the Odd and Even ques, starting by popping from the Odd, since no matter the word, second letter of it is always even in terms of order. Then I would finish by adding the last letter of the original word on top. After each word, I would add an element from the punctuation array, and repeat the process, iterating through each word element and adding a punctuation element afterwards. The process repeats until there are no more elements.

Testin/Debugging: I've ran numerous tests which caused me to go back and refine my algorithm as well as tests in the terminal to ensure it runs well eliminating bugs along the way. I've decided not to use refactoring techniques for this simple project, but for something more complex in the future, I would definitely ensure to eliminate unnecessary methods, reduce coupling and increase cohesiveness between methods and classes to ensure products extensibility and ease of use. 



Question 2: "What was the most difficult aspect of the solution?" (500 words or less)

Answer: 

  The most challenging part was initially figuring out how to tackle entire sentences at a time. With different punctuations and spacing it was hard for me to visualize a good approach for reading an entire paragraph at a time and recognizing words as well as punctuations. Therefore, I have decided to break it down into a more doable, smaller task, such as shuffling just one word at a time and concatenating it with a punctuation. I had an idea to create 2 seperate arrays for words and punctuations but I was making the process way more complicated than it should have been. Some time, and some serious struggling afterwards I've found a very simple way to do it with a string split method and use regular expression to filter out the things I wanted to leave out of each array. After succesfully getting the results I wanted, all I had to do was feed individual words into my shuffling algorithm and append them with punctiations from the corresponding array. Problem solved!

  Second hardest thing, believe it or not, was to figure out how to shuffle words with apostrophies in them. I was thinking of just splitting the string into pre and post apostrophy bits and running those as seperate words but it didn't come without its problems. Although after a bit of consideration, I figured I could just append the apostrophy and last letter to the end of the word, after im done shuffling the first part. So I did just that and sure enough it worked like a charm!
