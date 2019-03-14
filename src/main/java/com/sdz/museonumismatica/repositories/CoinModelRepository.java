package com.sdz.museonumismatica.repositories;

import com.sdz.museonumismatica.CoinModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Victor Fernandez
 */

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

    List<CoinModel> findAllByDiameterLessThanEqual(int max);
    List<CoinModel> findAllByDiameterLessThanEqualOrderByFaceValueAsc(int max);
    List<CoinModel> findAllByDiameterLessThanEqualOrderByFaceValueDesc(int max);
    List<CoinModel> findAllByDiameterLessThanEqualOrderByWeightAsc(int max);
    List<CoinModel> findAllByDiameterLessThanEqualOrderByWeightDesc(int max);
    List<CoinModel> findAllByDiameterLessThanEqualOrderByCurrencyAsc(int max);
    List<CoinModel> findAllByDiameterLessThanEqualOrderByCurrencyDesc(int max);

    List<CoinModel> findAllByDiameterGreaterThanEqual(int min);
    List<CoinModel> findAllByDiameterGreaterThanEqualOrderByFaceValueAsc(int min);
    List<CoinModel> findAllByDiameterGreaterThanEqualOrderByFaceValueDesc(int min);
    List<CoinModel> findAllByDiameterGreaterThanEqualOrderByWeightAsc(int min);
    List<CoinModel> findAllByDiameterGreaterThanEqualOrderByWeightDesc(int min);
    List<CoinModel> findAllByDiameterGreaterThanEqualOrderByCurrencyAsc(int min);
    List<CoinModel> findAllByDiameterGreaterThanEqualOrderByCurrencyDesc(int min);

    List<CoinModel> findAllByWeightBetween(int min, int max);
    List<CoinModel> findAllByWeightBetweenOrderByFaceValueAsc(int min, int max);
    List<CoinModel> findAllByWeightBetweenOrderByFaceValueDesc(int min, int max);
    List<CoinModel> findAllByWeightBetweenOrderByWeightAsc(int min, int max);
    List<CoinModel> findAllByWeightBetweenOrderByWeightDesc(int min, int max);
    List<CoinModel> findAllByWeightBetweenOrderByCurrencyAsc(int min, int max);
    List<CoinModel> findAllByWeightBetweenOrderByCurrencyDesc(int min, int max);

    List<CoinModel> findAllByWeightLessThanEqual(int max);
    List<CoinModel> findAllByWeightLessThanEqualOrderByFaceValueAsc(int max);
    List<CoinModel> findAllByWeightLessThanEqualOrderByFaceValueDesc(int max);
    List<CoinModel> findAllByWeightLessThanEqualOrderByWeightAsc(int max);
    List<CoinModel> findAllByWeightLessThanEqualOrderByWeightDesc(int max);
    List<CoinModel> findAllByWeightLessThanEqualOrderByCurrencyAsc(int max);
    List<CoinModel> findAllByWeightLessThanEqualOrderByCurrencyDesc(int max);

    List<CoinModel> findAllByWeightGreaterThanEqual(int min);
    List<CoinModel> findAllByWeightGreaterThanEqualOrderByFaceValueAsc(int min);
    List<CoinModel> findAllByWeightGreaterThanEqualOrderByFaceValueDesc(int min);
    List<CoinModel> findAllByWeightGreaterThanEqualOrderByWeightAsc(int min);
    List<CoinModel> findAllByWeightGreaterThanEqualOrderByWeightDesc(int min);
    List<CoinModel> findAllByWeightGreaterThanEqualOrderByCurrencyAsc(int min);
    List<CoinModel> findAllByWeightGreaterThanEqualOrderByCurrencyDesc(int min);

    List<CoinModel> findByMetalsIn(Set<String> metals);
    List<CoinModel> findByDescriptionContaining(String desc);

}
