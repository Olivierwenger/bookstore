<template>
  <InputText
      @input="searchIsbn"
      class="form-control"
      id="isbn"
      v-model="isbn"
      type="number"
      name="isnbn"
      minlength="10"
      maxlength="13"
      :disabled="disabled"
  />
</template>

<script>
export default {
  name: "IsbnSearch",
  data() {
    return {
      isbn: "",
    }
  },
  props: {
    inputFunction: {},
    disabled: {
      type: Boolean,
      default: false,
    },
    apiPath: {
      type: String,
      default: "/api/book/ISBN?isbn="
    },
    resetOnFound: {
      type: Boolean,
      default: false,
    }
  },
  methods: {
    searchIsbn: function () {
      console.debug("fetching data")
      console.log(this.isbn)
      if (this.isbn.length === 13) {
        fetch(this.apiPath + this.isbn)
            .then((response) => response.text())
            .then((data) => {
              if (this.resetOnFound) {
                this.isbn = "";
              }
              this.$emit('book', JSON.parse(data))
            })
            .catch((e) => this.$emit('message', {severity: 'warn', content: `Le livre n'a pas pu être trouvé {}`+ e}))
      }
    },
  }

}
</script>

<style scoped>

</style>