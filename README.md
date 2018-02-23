# file reader
by Hayato Kawai		

I ran the tasks on a notebook with 2.60 GHz i7-6700HQ,
and got these results :

Task												| Time
----------------------------------------------------|-------------------
Read file 52539-char at a time to String            | 0.6655356 sec. 
Read file 52539-char at a time to StringBuilder     | 0.0030640 sec. 
Read file 52539-char at a time using BufferedReader | 0.5909530 sec. 


