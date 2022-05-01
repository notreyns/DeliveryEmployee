package com.neobis.deliveryemployee.data.entity.mapper.mappers

import com.example.evergreenclient.data.entity.mapper.base.SimpleEntityMapper
import com.neobis.deliveryemployee.data.entity.florist.PlantEntity
import com.neobis.deliveryemployee.domain.interactor.model.PlantModel

class PlantMapper : SimpleEntityMapper<List<PlantModel>, List<PlantEntity>>() {

    override fun transform(entity: List<PlantEntity>): List<PlantModel> {
        return getModel(entity = entity)
    }

    private fun getModel(entity: List<PlantEntity>): List<PlantModel> {
        val collection = mutableListOf<PlantModel>()

        entity.forEach {
            var picture = ""
            if (it.picture.isNullOrEmpty()){
                picture = "https://uc5e3292a9d93974e2348aeb0d19.dl.dropboxusercontent.com/cd/0/get/Bjag9ojvELmWaG0xZI345zSmzcGQK0CIvA8WSaDzmRsB7JdGNUO5D0k8P_Ygz4coFNICmzloZKDIbzEZP-EXtpaHqwvoV08g1EcNOjFQ2W0ewv-F4SaraDTYgIEqsIeI0io9NJ1yMKP1xaLR7yAxzLGdadRbbkDXZr1_mHkwKsPExMJ460hmPX9NXGb1iNt3zyI/file"
            }else{
                picture = it.picture
            }
            val model = PlantModel(
                id = it.id,
                name = it.name.ifEmpty { "N/A" },
                picture = picture,
                categoryModel = it.category,
                date_created = it.date_created,
                florist = it.florist,
                price = it.price,
                quantity = it.quantity,
                sun = it.sun,
                temperature = it.temperature,
                watering = it.watering,
                is_sold = it.is_sold
            )
            collection.add(model)
        }
        return collection
    }




}
