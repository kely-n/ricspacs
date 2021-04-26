package controller;

import models.ImagingResult;
import models.Report;

/**
 * The RadiologyReportStatus enables a radiologist to observe an ImagingResult and write reports according to what he/she
 * finds on the result.
 */
public class RadiologyReportStatus {

    /**
     * method adds a report to database
     * @param imagingResult
     * @param report
     * @return 1 if successful, else 0
     */

    public static int createReport(ImagingResult imagingResult, Report report){
        return 1;
    }

    /**
     * updates a report
     * @param report
     * @return
     */
    public static int updateReport(Report report){

        return 1;
    }


}
