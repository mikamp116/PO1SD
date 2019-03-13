package com.sdz.museonumismatica.repositories;

import com.sdz.museonumismatica.CoinModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoinModelRepository extends JpaRepository<CoinModel, Long> {

    List<CoinModel> findAllByFaceValue(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByCurrencyAsc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByCurrencyDesc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByDiameterAsc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByDiameterDesc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByWeightAsc(float faceValue);
    List<CoinModel> findAllByFaceValueOrderByWeightDesc(float faceValue);

    List<CoinModel> findAllByCurrencyOrderByWeightAsc(String currency);
    List<CoinModel> findAllByCurrencyOrderByWeightDesc(String currency);
    List<CoinModel> findAllByCurrencyOrderByFaceValueAsc(String currency);
    List<CoinModel> findAllByCurrencyOrderByFaceValueDesc(String currency);
    List<CoinModel> findAllByCurrencyOrderByDiameterAsc(String currency);
    List<CoinModel> findAllByCurrencyOrderByDiameterDesc(String currency);

    List<CoinModel> findAllByCurrencyContainingOrderByWeightAsc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByWeightDesc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByFaceValueAsc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByFaceValueDesc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByDiameterAsc(String currency);
    List<CoinModel> findAllByCurrencyContainingOrderByDiameterDesc(String currency);

    List<CoinModel> findAllByDiameterBetween(int min, int max);
    List<CoinModel> findAllByDiameterBetweenOrderByFaceValueAsc(int min, int max);
    List<CoinModel> findAllByDiameterBetweenOrderByFaceValueDesc(int min, int max);
    List<CoinModel> findAllByDiameterBetweenOrderByWeightAsc(int min, int max);
    List<CoinModel> findAllByDiameterBetweenOrderByWeightDesc(int min, int max);
    List<CoinModel> findAllByDiameterBetweenOrderByCurrencyAsc(int min, int max);
    List<CoinModel> findAllByDiameterBetweenOrderByCurrencyDesc(int min, int max);
}
