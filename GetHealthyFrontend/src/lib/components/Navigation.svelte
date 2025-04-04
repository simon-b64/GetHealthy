<script lang="ts">
	import { page } from '$app/state';
	import { BottomNav, BottomNavItem } from 'flowbite-svelte';
	import {
		HomeSolid,
		WalletSolid,
		AdjustmentsVerticalOutline,
		UserCircleSolid
	} from 'flowbite-svelte-icons';

	const activeUrl = $derived(page.url.pathname);
</script>

<nav>
	<BottomNav {activeUrl} position="absolute" classInner="grid-cols-4">
		<BottomNavItem btnName="Home">
			<HomeSolid
				class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400"
			/>
		</BottomNavItem>
		<BottomNavItem btnName="Wallet">
			<WalletSolid
				class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400"
			/>
		</BottomNavItem>
		<BottomNavItem btnName="Settings">
			<AdjustmentsVerticalOutline
				class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400"
			/>
		</BottomNavItem>
		<BottomNavItem btnName="Profile">
			<UserCircleSolid
				class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400"
			/>
		</BottomNavItem>
	</BottomNav>
</nav>
