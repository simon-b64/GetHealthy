<script lang="ts">
    import { Card, Progressbar, Span } from 'flowbite-svelte';
</script>

<svelte:head>
    <title>Tracking</title>
    <meta name="description" content="Calorie tracker" />
</svelte:head>

<section class="tracking-section">
    <Card>
        <div class="flex flex-col gap-4">
            <div class="flex justify-between">
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Span>300</Span>
                    <Span>Eaten</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Span>300</Span>
                    <Span>Remaining</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Span>300</Span>
                    <Span>Burned</Span>
                </div>
            </div>
            <div class="flex justify-between">
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Progressbar progress="50" />
                    <Span>Carbs</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Progressbar progress="50" />
                    <Span>Protein</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Progressbar progress="50" />
                    <Span>Fat</Span>
                </div>
            </div>
        </div>
    </Card>
</section>

<style>
    .tracking-section {
        padding: 0.5rem;
    }
</style>
