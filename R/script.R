```{r}
#split amino acids into different sheets
library(tidyr)
data <- read.csv("Molecule Ratio Results.csv", sep = ",")
data <- separate(data, col = Quantification, into = c("quantification", "unit"), sep = "uM")
data <- separate(data, col = Replicate, into = c("Project", "year", "month", "date", "AA", "PlateNum", "Patient", "Treatment", "Dilution"), sep = "_")
data$unit <- "uM"
data$Final_Concentration <- NA
data$Symbol <- NA

interactionFactor <- interaction(data$Molecule, data$Patient)
print(interactionFactor)
split_data <- split(data, interactionFactor)



                   
length(split_data)

split_data_result <- split_data

#for (i in 1:length(split_data)){
  #a <- split_data[[i]]
  #b <- a %>% dplyr::select(Molecule, Replicate, quantification, unit)
  #all_sd <- a$Analyte.Concentration[a$Exclude.From.Calibration == "False"] %>% na.omit()
  #b$SD_range <- paste0(min(all_sd),"-",max(all_sd))
  #b$quantification <- as.numeric(b$quantification)
  #b$`out of linear range` <- ifelse(b$quantification < min(all_sd)*0.8 | b$quantification > max(all_sd)*1.5, "*", "")
  #split_data_result[[i]] <- b
 
#}
library(ggplot2)
for (i in 1:length(split_data)){
  split_data[[i]]$quantification <- as.numeric(split_data[[i]]$quantification)
 
  for (m in seq_len(nrow(split_data[[i]]))) {
   
    if ((split_data[[i]]$quantification[m]<2.5))
    {
      split_data[[i]]$Symbol[m] <- "-"
      next
    }
   
    if ((split_data[[i]]$quantification[m]>750))
    {
      split_data[[i]]$Symbol[m] <- "+"
      next
    }

   
   if (split_data[[i]]$Dilution[m] == "DIL") {
    split_data[[i]]$Final_Concentration[m] <- 10*split_data[[i]]$quantification[m]
   }
   
   else if (split_data[[i]]$Dilution[m] == "UNDIL") {
   split_data[[i]]$Final_Concentration[m] <- 2*split_data[[i]]$quantification[m]
  }
 
     
}
   

   
   
  plot_aa <- as.character(split_data[[i]][2, 1])
  plot_patient <- as.character(split_data[[i]][2, 8])
  combined <- paste (plot_aa, plot_patient)

  desired_order <- c("PBS", "AMIOCA", "MSPRE", "LDOGB", "HIMAIZE", "NOVELOSE", "VERSAFIBE", "LACTULOSE", "STACHYOSE", "PULLULAN", "ARABINOXYLAN", "GOS", "INULIN", "FOS", "FOSSIGMA", "KES")
  categories <- factor(split_data[[i]]$Treatment, levels = desired_order)
  background_colors <- c("#FF9999", "#FF9999", "#66B2FF", "#66B2FF", "#66B2FF", "#66B2FF", "#66B2FF", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#FFCC99", "#FFCC99")
  rect_width <- 0.8
  values <- split_data[[i]]$Final_Concentration
  Symbol <- split_data[[i]]$Symbol

  my_plot <- ggplot(split_data[[i]], aes(x = categories, y = values)) +
  geom_rect(aes(fill = categories),
            xmin = as.numeric(categories) - 0.5,
            xmax = as.numeric(categories) + 0.5,
            ymin = -Inf, ymax = Inf, alpha = 0.5) +
  stat_summary(fun = mean, geom = "point", color = "red", size = 3, position = "identity")+
  geom_text(aes(label = Symbol, y=5), vjust = 0, size = 5, color = "black") +

  coord_cartesian(ylim = c(0, 7500))+
  geom_point(alpha = 0) +
  scale_fill_manual(values = background_colors) +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))+
  ggtitle(combined) +
  xlab("Treatment") +
  ylab("Final Quantification uM")

 
 



 
  ggsave(filename = paste0(combined, ".png"), plot = my_plot)
  #dev.copy(png, filename = paste0 (combined, ".png"))
  #dev.off()
 
 
  }

library(writexl)
write_xlsx(split_data, path = "amino acids split.xlsx")
write_xlsx(split_data_result, path = "amino acids split result.xlsx")



```
