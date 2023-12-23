```{r}
#split biomass into different sheets
library(tidyr)
library(writexl)
library(purrr)
library(dplyr)

dataBaseline <- read.csv("Media and Treatment Baseline.csv", sep = ",")


split_data <- split(dataBaseline, dataBaseline$Molecule)

write_xlsx(split_data, path = "Baseline split.xlsx")





```