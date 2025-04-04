<script lang="ts">
    import '../app.css';
    import Navigation from '$lib/components/Navigation.svelte';

    let { children } = $props();
</script>

<div class="app">
    <main>
        {@render children()}
    </main>
    <Navigation />
</div>

<style>
</style>
