<template>    
    <div id="app" >
      <h1>Habr</h1>
      <hr>
      <div class="page_wrap">
        <article>
          <NewsItem msg="Welcome to Your Vue.js App"/>
        </article>    
      </div>    
  </div>
</template>

<script>
import NewsItem from './components/NewsItem.vue'

export default {
  name: 'App',
  components: {
    NewsItem
  }
}
</script>

<style>
  h1 {
    text-align: center;
  }
  #app {
    font-family: CustomSerif,Georgia,Cambria,'Times New Roman',serif;
    font-weight: 400;
    font-style: normal;
    font-size: 18px;
    line-height: 1.58;
    padding: 0;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    margin-top: 60px;
  }
  .page_wrap {
      max-width: 732px;
      margin: 0 auto;
  }
  .p-accordion .p-accordion-header .p-accordion-header-link {
      border: none;
      background: none; 
  }
  .pi-chevron-right::before {
      content: none !important;
      display: none !important
  }
  .pi-chevron-down::before {
      content: none !important;
      display: none !important
  }
</style>
