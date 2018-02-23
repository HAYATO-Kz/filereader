## file reader
by Hayato Kawai		

I ran the tasks on a notebook with 2.60 GHz i7-6700HQ,
and got these results :

Task												| Time
----------------------------------------------------|-------------------
Read file 52539-char at a time to String            | 0.6655356 sec. 
Read file 52539-char at a time to StringBuilder     | 0.0030640 sec. 
Read file 52539-char at a time using BufferedReader | 0.5909530 sec. 

## Explanation of Results

Read file to StringBuilder is the fastest method because StringBuilder will read  One by one char and combine them together

Read file by using BufferReadder is the fast method but not fastest than use StringBuilder because BufferReader will read line by line and combine them together.

Read file to String is the slowest method because String can read only 1 char per time
 
