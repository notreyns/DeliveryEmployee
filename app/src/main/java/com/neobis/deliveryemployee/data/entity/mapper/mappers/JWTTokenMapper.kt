package com.neobis.deliveryclient.data.entity.mapper.mappers

import com.example.evergreenclient.data.entity.mapper.base.SimpleEntityMapper
import com.neobis.deliveryclient.data.entity.JWTTokenEntity
import com.neobis.deliveryclient.domain.interactor.model.JWTTokenModel

class JWTTokenMapper : SimpleEntityMapper<JWTTokenModel, JWTTokenEntity>() {

    override fun transform(entity: JWTTokenEntity): JWTTokenModel {
        return getModel(entity)
    }

    private fun getModel(entity: JWTTokenEntity): JWTTokenModel {

        val model =JWTTokenModel(
            role= entity.role,
            access = entity.access,
            refresh = entity.refresh
        )
        return model
    }


}


