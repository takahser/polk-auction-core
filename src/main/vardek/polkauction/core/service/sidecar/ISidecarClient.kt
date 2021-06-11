package vardek.polkauction.core.service.sidecar

import vardek.polkauction.core.model.Auction
import vardek.polkauction.core.model.Parachain

interface ISidecarClient {

    suspend fun GetParas(): List<Parachain>

    suspend fun GetAuction(): Auction
}