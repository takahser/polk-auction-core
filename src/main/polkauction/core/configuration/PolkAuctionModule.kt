package polkauction.core.configuration

import org.koin.dsl.module
import polkauction.core.repository.IParachainRepository
import polkauction.core.repository.IRelayChainRepository
import polkauction.core.repository.ParachainRepository
import polkauction.core.repository.RelayChainRepository
import polkauction.core.service.*
import polkauction.core.service.sidecar.ISidecarClientFactory
import polkauction.core.service.sidecar.SidecarClientFactory

val polkAuctionCoreModule = module(createdAtStart = true) {
    // Services
    single<ISidecarClientFactory> { SidecarClientFactory() }

    single<IAuctionService> { AuctionService(get(), get()) }
    single<ICrowdloanService> { CrowdloanService(get(), get()) }
    single<IParachainService> { ParachainService(get(), get()) }
    single<IRuntimeService> { RuntimeService(get()) }

    //Repositories
    single<IRelayChainRepository> { RelayChainRepository() }
    single<IParachainRepository> { ParachainRepository() }
}