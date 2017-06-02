# Calculating-Visualizing-Dyadic-Interactions-for-Medical-Data-in-DC-VA-MD-Area

This file contains details about the process that was undertaken, the code that was used and the sample output that I got. 

## People Involved 
For this project , I was referred by [Professor Liang Zhao](http://ist.gmu.edu/people/detail/liang-zhao/) to work on a project with [Professor Seth Kaplan](http://psychology.gmu.edu/people/skaplan1) and [Xue Lei](http://psychology.gmu.edu/people/xlei2 ). 

## Background 
I worked on data provided by [Medstar Health Research Institute]( https://www.medstarhealth.org/mhri/#q={} ) . The data consisted of a list of surgeries performed in the DC-VA-MD region, and the doctors involved in each surgery. For confidentiality reasons , I am not allowed to publish the data to a public platform. The objective of the job was to calculate the dyadic interactions between each doctor , which could further be refined by different parameters like time periods , type of surgery , roles etc . 

## Objectives 
- The purpose of this project is to identify combinations of doctors who work well ( in this case , work well means the ability to perform a surgery in the least amount of time)  which can directly impact hospital resource allocation in the form of capital and human resources  .
- The project also aims to identify if there is any correlation between different attributes of the doctor ( age , qualifications , type of patient treated etc ) and surgery time . 
- Lastly , it also aims to analyze the frequency of interactions between doctors over time. 

## Details 
- Time taken : ~ 2 months . 
- Languages and tools used : Java , Microsoft Excel , VBA , Gephi , Tableau . 

## Data description 
I was given data for four years (2013 , 2014 , 2015 , 2016) . The column headers (which explain what kind of data is present in each column) along with the number of entries for each year have been mentioned in **data column description.xlsx**. While some columns like CheckInDate do not have any null cells , some other columns like Anesthesia Assistant Student 2 , Circulator - Other 1 etc do have null values ( the logic here is that while each surgery , which is a row , needs to have a CheckInDate , it might not have a doctor for *every* role that has been mentioned). 

## Data Cleaning 

- Firstly, I had to combine all the four data files into a single file. Since some files had more columns and some had less , the logic used here is to have a single excel file with all the possible roles , and leave the ones without a role for that year blank. For example , 2013 might have surgeon1, surgeon2 and surgeon3 , while 2014 might have only surgeon1. To take care of this issue, the merged file has surgeon1, surgeon2 and surgeon3, with the entries corresponding to 2014 having null cells for surgeon2 and surgeon3.

- Secondly, I had to remove roles that were not needed. The requirement was to calculate the dyadic interactions only for a few select roles, not all of them. So I had to remove roles that were not required. The selection was done according to the constraints mentioned in case attendee roles.xlsx . 
- Thirdly , I had to deal with anomalies / incorrect entries in the data. For example , some of the entries for the doctors were simply listed as “Unknown” , which had to be removed. A few doctors ( referring to the same person ) were given similar names , which had to be replaced. Additionally, I had a few names that I was not sure about , which I had to clarify with Professor Kaplan . 

- Fourthly , I had to make the data machine readable . This involved removing special characters and converting the data to UTF-8 format. Apart from this , there were a few additional steps which I had to do to make sure the data could be read by the code ( for instance , removing the “-“ character which was being read as a separate entry by the code ) . 

## Calculating Dyadic Interactions 

- Once I had a merged file , I had to calculate the dyadic interaction for the doctors. This took 6 iterations , where I met with Professor Kaplan and Xue to understand what the requirements were. 
The code ( along with the iterations ) has been mentioned in the folder titled “Code” . 

- I had to optimize the code to make sure that the amount of memory being consumed by the system was limited ( for the first iteration of the code , the system sucked in close to 11GB of memory within a few minutes of it being run ) . I did this by writing the output in a manner which made use of Java’s existing data types . The final code used up close to 8GB of memory . The memory usage increased in an exponential fashion , as it should ( the more values it is comparing for the dyadic interactions , the more data needs to be stored temporarily for the program to compare against) . 

- Additionally , I split the output into two parts for memory optimization. 
I wrote the code so that the dyadic interactions for any subset of the data can be calculated. 
I also explained how the code worked and how to execute it to Professor Kaplan and Xue . 

## Other Tasks 
This included work that I did but was deemed not necessary / no further progress requested. 
-	I wanted to represent each doctor by a numeric entry instead of a name , and wrote a simple excel macro which did the same . I presented the idea to Professor Kaplan , and he told me that he would prefer it if the names were included , instead of numbers. The basic idea for doing this was that it would be easier for the program to execute if it was comparing numbers instead of text strings. 
-	I also suggested to Professor Kaplan that we could visualize the interaction data better using Gephi and Tableau. I presented a sample output of the same and made full scale interactions for my own use ( he didn’t really ask for it nor did I show it to him , but you know , for teh lulz xD ). 

## Notes 
Unfortunately , collaboration is not possible for this project. I however would welcome your suggestions ! Shoot me a mail at sdonthin@gmu.edu :) . 




