package de.hdmstuttgart.fitnessapp.database.repositories;
import de.hdmstuttgart.fitnessapp.database.daos.ExerciseTPDao;
import de.hdmstuttgart.fitnessapp.database.entities.relations.ExerciseTrainingsPlanCrossRef
import kotlinx.coroutines.flow.Flow

class ExerciseTPRepository(private val crossRefDao: ExerciseTPDao) {
    suspend fun insertCrossRef(crossRef: ExerciseTrainingsPlanCrossRef) = crossRefDao.insertOrUpdateCrossRef(crossRef)

    suspend fun updateCrossRef(crossRef: ExerciseTrainingsPlanCrossRef) = crossRefDao.insertOrUpdateCrossRef(crossRef)

    suspend fun insertListOfCrossRef(crossRefList: List<ExerciseTrainingsPlanCrossRef>) = crossRefDao.insertListOfCrossRef(crossRefList)

    suspend fun deleteCrossRef(crossRef: ExerciseTrainingsPlanCrossRef) = crossRefDao.deleteCrossRef(crossRef)

    fun getAllCrossRefs(): Flow<List<ExerciseTrainingsPlanCrossRef>> = crossRefDao.getAllCrossRefs()
}
