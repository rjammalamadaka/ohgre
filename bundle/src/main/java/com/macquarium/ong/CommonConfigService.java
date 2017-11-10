package com.macquarium.ong;

public interface CommonConfigService {
    public static final long serialVersionUID = 1L;

    public String getPrimeEndPoint();
    public String getPrimeHeaderHandlerUrl();
    public String getDeltaSkyMilesEndPoint();
    public String getMySqlConnectionUrl();
    public String getDataBaseUsername();
    public String getDataBasePassword();
    public String getWhatCountsUrl();
    public String getToMailAddress();


}
