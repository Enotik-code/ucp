package com.example.sweater.calculate;

import com.example.sweater.domain.Delivery;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Delivery> bestItems = null;

    private double maxW;

    private double bestPrice;

    public Backpack(double _maxW)
    {
        maxW = _maxW;
    }

    private double CalcWeight(List<Delivery> items)
    {
        double sumW = 0;

        for (Delivery i: items) {
            sumW += i.getVolume();
        }

        return sumW;
    }

    private double CalcPrice(List<Delivery> items)
    {
        double sumPrice = 0;

        for (Delivery i: items)
        {
            sumPrice += i.getDeliveryCost();
        }
        return sumPrice;
    }

    private void CheckSet(List<Delivery> items)
    {
        if (bestItems == null)
        {
            if (CalcWeight(items) <= maxW)
            {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
        else
        {
            if(CalcWeight(items) <= maxW && CalcPrice(items) > bestPrice)
            {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
    }

    public void makeAllSets(List<Delivery> items)
    {
        if (items.size() > 0)
            CheckSet(items);

        for (int i = 0; i < items.size(); i++)
        {
            List<Delivery> newSet = new ArrayList<>(items);
            newSet.remove(i);

            makeAllSets(newSet);
        }
    }

    public List<Delivery> GetBestSet()
    {
        return bestItems;
    }


}
