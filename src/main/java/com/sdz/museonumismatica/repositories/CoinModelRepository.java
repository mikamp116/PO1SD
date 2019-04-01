package com.sdz.museonumismatica.repositories;

import com.sdz.museonumismatica.CoinModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Victor Fernandez
 */

public interface CoinModelRepository extends JpaRepository<CoinModel, Long> {

    // Buscar por valor facial
    List<CoinModel> findAllByFaceValue(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByDiameterAsc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByDiameterDesc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByWeightAsc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByWeightDesc(float faceValue);

    //Buscar por valor facial y diametro
    List<CoinModel> findAllByFaceValueAndDiameter(float faceValue, float diameter);
    List<CoinModel> findAllByFaceValueAndDiameterOrderByDiameterAsc(float faceValue, float diameter);
    List<CoinModel> findAllByFaceValueAndDiameterOrderByDiameterDesc(float faceValue, float diameter);
    List<CoinModel> findAllByFaceValueAndDiameterOrderByWeightAsc(float faceValue, float diameter);
    List<CoinModel> findAllByFaceValueAndDiameterOrderByWeightDesc(float faceValue, float diameter);
    List<CoinModel> findAllByFaceValueAndDiameterOrderByFaceValueAsc(float faceValue, float diameter);
    List<CoinModel> findAllByFaceValueAndDiameterOrderByFaceValueDesc(float faceValue, float diameter);

    //Buscar por valor facial y peso
    List<CoinModel> findAllByFaceValueAndWeight(float faceValue, float weight);
    List<CoinModel> findAllByFaceValueAndWeightOrderByDiameterAsc(float faceValue, float weight);
    List<CoinModel> findAllByFaceValueAndWeightOrderByDiameterDesc(float faceValue, float weight);
    List<CoinModel> findAllByFaceValueAndWeightOrderByWeightAsc(float faceValue, float weight);
    List<CoinModel> findAllByFaceValueAndWeightOrderByWeightDesc(float faceValue, float weight);
    List<CoinModel> findAllByFaceValueAndWeightOrderByFaceValueAsc(float faceValue, float weight);
    List<CoinModel> findAllByFaceValueAndWeightOrderByFaceValueDesc(float faceValue, float weight);

    //Buscar por valor facial y divisa
    List<CoinModel> findAllByFaceValueAndCurrencyContaining(float faceValue, String currency);
    List<CoinModel> findAllByFaceValueAndCurrencyContainingOrderByDiameterAsc(float faceValue, String currency);
    List<CoinModel> findAllByFaceValueAndCurrencyContainingOrderByDiameterDesc(float faceValue, String currency);
    List<CoinModel> findAllByFaceValueAndCurrencyContainingOrderByWeightAsc(float faceValue, String currency);
    List<CoinModel> findAllByFaceValueAndCurrencyContainingOrderByWeightDesc(float faceValue, String currency);
    List<CoinModel> findAllByFaceValueAndCurrencyContainingOrderByFaceValueAsc(float faceValue, String currency);
    List<CoinModel> findAllByFaceValueAndCurrencyContainingOrderByFaceValueDesc(float faceValue, String currency);

    //Buscar por valor facial y metales
    List<CoinModel> findAllByFaceValueAndMetals(float faceValue, TreeSet<String> metals);
    List<CoinModel> findAllByFaceValueAndMetalsOrderByDiameterAsc(float faceValue, TreeSet<String> metals);
    List<CoinModel> findAllByFaceValueAndMetalsOrderByDiameterDesc(float faceValue, TreeSet<String> metals);
    List<CoinModel> findAllByFaceValueAndMetalsOrderByWeightAsc(float faceValue, TreeSet<String> metals);
    List<CoinModel> findAllByFaceValueAndMetalsOrderByWeightDesc(float faceValue, TreeSet<String> metals);
    List<CoinModel> findAllByFaceValueAndMetalsOrderByFaceValueAsc(float faceValue, TreeSet<String> metals);
    List<CoinModel> findAllByFaceValueAndMetalsOrderByFaceValueDesc(float faceValue, TreeSet<String> metals);

    //Buscar por divisa
    List<CoinModel> findAllByCurrencyContaining(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByWeightAsc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByWeightDesc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByFaceValueAsc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByFaceValueDesc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByDiameterAsc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByDiameterDesc(String currency);

    //Buscar por divisa y diametro
    List<CoinModel> findAllByCurrencyContainingAndDiameter(String currency, float diameter);
    List<CoinModel> findAllByCurrencyContainingAndDiameterOrderByWeightAsc(String currency, float diameter);
    List<CoinModel> findAllByCurrencyContainingAndDiameterOrderByWeightDesc(String currency, float diameter);
    List<CoinModel> findAllByCurrencyContainingAndDiameterOrderByFaceValueAsc(String currency, float diameter);
    List<CoinModel> findAllByCurrencyContainingAndDiameterOrderByFaceValueDesc(String currency, float diameter);
    List<CoinModel> findAllByCurrencyContainingAndDiameterOrderByDiameterAsc(String currency, float diameter);
    List<CoinModel> findAllByCurrencyContainingAndDiameterOrderByDiameterDesc(String currency, float diameter);

    //Buscar por divisa y peso
    List<CoinModel> findAllByCurrencyContainingAndWeight(String currency, float weight);
    List<CoinModel> findAllByCurrencyContainingAndWeightOrderByWeightAsc(String currency, float weight);
    List<CoinModel> findAllByCurrencyContainingAndWeightOrderByWeightDesc(String currency, float weight);
    List<CoinModel> findAllByCurrencyContainingAndWeightOrderByFaceValueAsc(String currency, float weight);
    List<CoinModel> findAllByCurrencyContainingAndWeightOrderByFaceValueDesc(String currency, float weight);
    List<CoinModel> findAllByCurrencyContainingAndWeightOrderByDiameterAsc(String currency, float weight);
    List<CoinModel> findAllByCurrencyContainingAndWeightOrderByDiameterDesc(String currency, float weight);

    //Buscar por divisa y metales
    List<CoinModel> findAllByCurrencyContainingAndMetals(String currency, TreeSet<String> metals);
    List<CoinModel> findAllByCurrencyContainingAndMetalsOrderByWeightAsc(String currency, TreeSet<String> metals);
    List<CoinModel> findAllByCurrencyContainingAndMetalsOrderByWeightDesc(String currency, TreeSet<String> metals);
    List<CoinModel> findAllByCurrencyContainingAndMetalsOrderByFaceValueAsc(String currency, TreeSet<String> metals);
    List<CoinModel> findAllByCurrencyContainingAndMetalsOrderByFaceValueDesc(String currency, TreeSet<String> metals);
    List<CoinModel> findAllByCurrencyContainingAndMetalsOrderByDiameterAsc(String currency, TreeSet<String> metals);
    List<CoinModel> findAllByCurrencyContainingAndMetalsOrderByDiameterDesc(String currency, TreeSet<String> metals);

    //Buscar por diametro
    List<CoinModel> findAllByDiameter(float diameter);
    List<CoinModel> findAllByDiameterOrderByFaceValueAsc(float diameter);
    List<CoinModel> findAllByDiameterOrderByFaceValueDesc(float diameter);
    List<CoinModel> findAllByDiameterOrderByWeightAsc(float diameter);
    List<CoinModel> findAllByDiameterOrderByWeightDesc(float diameter);

    //Buscar por diametro y metales
    List<CoinModel> findAllByDiameterAndMetals(float diameter, TreeSet<String> metals);
    List<CoinModel> findAllByDiameterAndMetalsOrderByFaceValueAsc(float diameter, TreeSet<String> metals);
    List<CoinModel> findAllByDiameterAndMetalsOrderByFaceValueDesc(float diameter, TreeSet<String> metals);
    List<CoinModel> findAllByDiameterAndMetalsOrderByWeightAsc(float diameter, TreeSet<String> metals);
    List<CoinModel> findAllByDiameterAndMetalsOrderByWeightDesc(float diameter, TreeSet<String> metals);
    List<CoinModel> findAllByDiameterAndMetalsOrderByDiameterAsc(float diameter, TreeSet<String> metals);
    List<CoinModel> findAllByDiameterAndMetalsOrderByDiameterDesc(float diameter, TreeSet<String> metals);

    //Buscar por diametro y peso
    List<CoinModel> findAllByDiameterAndWeight(float diameter, float weight);
    List<CoinModel> findAllByDiameterAndWeightOrderByFaceValueAsc(float diameter, float weight);
    List<CoinModel> findAllByDiameterAndWeightOrderByFaceValueDesc(float diameter, float weight);
    List<CoinModel> findAllByDiameterAndWeightOrderByWeightAsc(float diameter, float weight);
    List<CoinModel> findAllByDiameterAndWeightOrderByWeightDesc(float diameter, float weight);
    List<CoinModel> findAllByDiameterAndWeightOrderByDiameterAsc(float diameter, float weight);
    List<CoinModel> findAllByDiameterAndWeightOrderByDiameterDesc(float diameter, float weight);

    //Buscar por peso
    List<CoinModel> findAllByWeight(float weight);
    List<CoinModel> findAllByWeightOrderByFaceValueAsc(float weight);
    List<CoinModel> findAllByWeightOrderByFaceValueDesc(float weight);
    List<CoinModel> findAllByWeightOrderByDiameterAsc(float weight);
    List<CoinModel> findAllByWeightOrderByDiameterDesc(float weight);

    //Buscar por peso y metales
    List<CoinModel> findAllByWeightAndMetals(float weight, TreeSet<String> metals);
    List<CoinModel> findAllByWeightAndMetalsOrderByFaceValueAsc(float weight, TreeSet<String> metals);
    List<CoinModel> findAllByWeightAndMetalsOrderByFaceValueDesc(float weight, TreeSet<String> metals);
    List<CoinModel> findAllByWeightAndMetalsOrderByWeightAsc(float weight, TreeSet<String> metals);
    List<CoinModel> findAllByWeightAndMetalsOrderByWeightDesc(float weight, TreeSet<String> metals);
    List<CoinModel> findAllByWeightAndMetalsOrderByDiameterAsc(float weight, TreeSet<String> metals);
    List<CoinModel> findAllByWeightAndMetalsOrderByDiameterDesc(float weight, TreeSet<String> metals);

    //Buscar por metales
    List<CoinModel> findAllByMetalsIn(TreeSet<String> metals);
    List<CoinModel> findAllByMetalsInOrderByFaceValueAsc(TreeSet<String> metals);
    List<CoinModel> findAllByMetalsInOrderByFaceValueDesc(TreeSet<String> metals);
    List<CoinModel> findAllByMetalsInOrderByWeightAsc(TreeSet<String> metals);
    List<CoinModel> findAllByMetalsInOrderByWeightDesc(TreeSet<String> metals);
    List<CoinModel> findAllByMetalsInOrderByDiameterAsc(TreeSet<String> metals);
    List<CoinModel> findAllByMetalsInOrderByDiameterDesc(TreeSet<String> metals);

}
