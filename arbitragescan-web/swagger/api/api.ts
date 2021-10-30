export * from './basicErrorController.service';
import { BasicErrorControllerService } from './basicErrorController.service';
export * from './exchangePriceController.service';
import { ExchangePriceControllerService } from './exchangePriceController.service';
export const APIS = [BasicErrorControllerService, ExchangePriceControllerService];
