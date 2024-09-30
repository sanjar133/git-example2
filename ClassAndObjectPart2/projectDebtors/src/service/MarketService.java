package service;


import model.Market;

import java.util.UUID;

public class MarketService {

    Market[] markets;
    public int indexMarket = 0;

    public MarketService(int size) {
        markets = new Market[size];
    }

    public boolean addMarket(Market market) {
        if (!hasMarket(market.username)) {
            markets[indexMarket++] = market;
            return true;
        }
        return false;
    }

    public boolean hasMarket(String userName) {
        for (int i = 0; i < indexMarket; i++) {
            if (markets[i].username.equals(userName)) {
                return true;
            }

        }
        return false;
    }

    public Market[] getMarkets() {
        return markets;
    }

    public Market getMarketById(UUID id) {
        for (Market market : markets) {
            if (market != null && market.id.equals(id)) {
                return market;
            }
        }
        return null;
    }

    public Market login(String username, String password) {
        for (Market market : markets) {
            if (market != null &&
                    market.username.equals(username) &&
                    market.password.equals(password)) {
                return market;
            }
        }
        return null;
    }
}
