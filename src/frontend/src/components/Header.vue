<template>
  <Menubar :model="items" />
</template>

<script>
export default {
  name: "Header.vue",
  data() {
    return {
      items: [
        {
          label:'Home',
          to: '/',
        },
        {
          label:'Stock',
          to: '/stock',
        },
        {
          label:'Ajout de livres',
          to: '/book/add',
        },
        {
          label: 'Inventaire',
          to: '/inventory',
        },
        {
          label: "Vendre des livres",
          to: '/book/sell',
        }
      ]
    }
  }

}
</script>

<style scoped>

</style>