import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'category',
                loadChildren: './category/category.module#ShopCategoryModule'
            },
            {
                path: 'product',
                loadChildren: './product/product.module#ShopProductModule'
            },
            {
                path: 'customer',
                loadChildren: './customer/customer.module#ShopCustomerModule'
            },
            {
                path: 'address',
                loadChildren: './address/address.module#ShopAddressModule'
            },
            {
                path: 'wish-list',
                loadChildren: './wish-list/wish-list.module#ShopWishListModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShopEntityModule {}
