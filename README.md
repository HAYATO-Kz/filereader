# file reader
by Hayato Kawai		

I ran the tasks on a notebook with 2.60 GHz i7-6700HQ,
and got these results :

Task												| Timee
----------------------------------------------------|-------------------:
Read file 52539-char at a time to String            | 1.108861 sec. 
Read file 52539-char at a time toStringBuilder      | 0.004821 sec. 
Read file 52539-char at a time using BufferedReader | 0.537080 sec. 