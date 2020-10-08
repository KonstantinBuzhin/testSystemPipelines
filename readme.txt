The app can read from .csv files(csvmapper), write into .csv files(csvwriter),
create a system of pipelines on basis of data from the files, insert into h2 DB files.
Initially the mapper maps data from the files to objects of pipelines and routes. We get list of those ones.
The app creates a system of pipelines where is information from possible the ways.
After that the app creates outputFile with data of checked ways and minimal length.
The DBWorker inserts into h2 DB two files - describer.csv and setter.csv.
  