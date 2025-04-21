<template>
    <div>
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Date
            label="OrderDate"
            v-model="value.orderDate"
            :editMode="editMode"
        />
        <InventoryId
            offline
            label="inventoryId"
            v-model="value.inventoryId"
            :editMode="editMode"
            @change="change"
        />
        <OrderItem
            offline
            label="orderItems"
            v-model="value.orderItems"
            :editMode="editMode"
            @change="change"
        />
        <OrderStatus
            offline
            label="OrderStatus"
            v-model="value.orderStatus"
            :editMode="editMode"
            @change="change"
        />
        <Address
            offline
            label="address"
            v-model="value.address"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Order',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "orders",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
